package com.endercrypt.jdarwin.bot;

import com.endercrypt.jdarwin.compiler.JDarwin;

import se.endercrypt.library.position.Motion;
import se.endercrypt.library.position.Position;

public class BotInfo
{
	private static final int SysUp = JDarwin.sysvars.get("up");
	private static final int SysDn = JDarwin.sysvars.get("dn");
	private static final int SysDx = JDarwin.sysvars.get("dx");
	private static final int SysSx = JDarwin.sysvars.get("sx");
	private static final int SysVelup = JDarwin.sysvars.get("velup");
	private static final int SysVeldn = JDarwin.sysvars.get("veldn");
	private static final int SysVeldx = JDarwin.sysvars.get("veldx");
	private static final int SysVelsx = JDarwin.sysvars.get("velsx");
	private static final int SysAimdx = JDarwin.sysvars.get("aimdx");
	private static final int SysAimsx = JDarwin.sysvars.get("aimsx");
	private static final int SysBodgain = JDarwin.sysvars.get("bodgain");
	private static final int SysBodloss = JDarwin.sysvars.get("bodloss");
	private static final int SysPain = JDarwin.sysvars.get("pain");
	private static final int SysPleas = JDarwin.sysvars.get("pleas");
	private static final int SysRobage = JDarwin.sysvars.get("robage");
	private static final int SysBody = JDarwin.sysvars.get("body");
	private static final int SysNrg = JDarwin.sysvars.get("nrg");
	private static final int SysTimer = JDarwin.sysvars.get("timer");
	private static final int SysAim = JDarwin.sysvars.get("aim");
	private static final int SysStrbody = JDarwin.sysvars.get("strbody");
	private static final int SysFdbody = JDarwin.sysvars.get("fdbody");
	private static final int SysKills = JDarwin.sysvars.get("kills");
	private static final int SysXpos = JDarwin.sysvars.get("xpos");
	private static final int SysYpos = JDarwin.sysvars.get("ypos");

	private static final double MOVEMENT_SPEED_MULTIPLIER = 0.05;
	private static final double FRICTION = 0.95;
	private static final double MAX_ENERGY = 32_000;

	private static final double QUARTER_ROTATION = Math.PI / 2;

	public int age = 0;
	public double energy = 3000;
	public double energyIncrease = 0;
	public double body = 100;
	public double bodyIncrease = 0;
	public int timer = 0;
	public int kills = 0;
	public double rotation = Math.random() * (Math.PI * 2);
	public Position position = new Position();
	public Motion motion = new Motion();

	public BotInfo()
	{

	}

	public void addEnergy(double by)
	{
		energy += by;
		energyIncrease += by;
	}

	public void addBody(double by)
	{
		body += by;
		bodyIncrease += by;
	}

	public void preUpdate(Bot bot) // set memory variables
	{
		Memory memory = bot.getMemory();

		memory.set(SysUp, 0);
		memory.set(SysDn, 0);
		memory.set(SysSx, 0);
		memory.set(SysDx, 0);
		double upVel = motion.getLengthByDirection(rotation);
		double leftVel = motion.getLengthByDirection(rotation - (Math.PI / 2));
		memory.set(SysVelup, (int) upVel);
		memory.set(SysVeldn, (int) -upVel);
		memory.set(SysVeldx, (int) leftVel);
		memory.set(SysVelsx, (int) -leftVel);
		memory.set(SysAimdx, 0);
		memory.set(SysAimsx, 0);
		memory.set(SysBodgain, (int) bodyIncrease);
		memory.set(SysBodloss, (int) -bodyIncrease);
		memory.set(SysPleas, (int) energyIncrease);
		memory.set(SysPain, (int) -energyIncrease);
		memory.set(SysRobage, age);
		memory.set(SysBody, (int) body);
		memory.set(SysNrg, (int) energy);
		memory.set(SysTimer, timer);
		memory.set(SysAim, (int) (rotation * 200));
		memory.set(SysKills, kills);
		memory.set(SysXpos, (int) position.x);
		memory.set(SysYpos, (int) position.y);

		energyIncrease = 0;
		bodyIncrease = 0;
	}

	public void postUpdate(Bot bot) // read memory variables
	{
		Memory memory = bot.getMemory();

		age++;
		timer++;
		position.add(motion);

		rotation -= (memory.get(SysAimsx) - memory.get(SysAimdx)) / 200.0;

		motion.addMotion(rotation, (memory.get(SysUp) - memory.get(SysDn)) * MOVEMENT_SPEED_MULTIPLIER);
		motion.addMotion(rotation - QUARTER_ROTATION, (memory.get(SysSx) - memory.get(SysDx)) * MOVEMENT_SPEED_MULTIPLIER);
		motion.multiplyLength(FRICTION);
		motion.truncateLength(40 * MOVEMENT_SPEED_MULTIPLIER);

		if (energy > MAX_ENERGY)
		{
			double bodyChange = (energy - MAX_ENERGY) / 10;
			addBody(bodyChange);
			energy = MAX_ENERGY;
		}
		double bodyChange = (memory.get(SysStrbody) - memory.get(SysFdbody));
		bodyChange = minMax(bodyChange, 100);
		addBody(bodyChange);
		addEnergy(-(bodyChange * 10));
	}

	private double minMax(double value, int minMax)
	{
		value = Math.min(minMax, value);
		value = Math.max(-minMax, value);
		return value;
	}
}
