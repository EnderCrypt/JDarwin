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

	private static final double MAX_ENERGY = 32_000;

	private int age = 0;
	private double energy = 3000;
	private double energyIncrease = 0;
	private double body = 100;
	private double bodyIncrease = 0;
	private int timer = 0;
	private int kills = 0;
	private double rotation = Math.random() * (Math.PI * 2);
	private Position position = new Position();
	private Motion motion = new Motion();

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
		memory.set(SysVelup, (int) -motion.y);
		memory.set(SysVeldn, (int) motion.y);
		memory.set(SysVeldx, (int) -motion.x);
		memory.set(SysVelsx, (int) motion.x);
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

		rotation -= (memory.get(SysAimsx) - memory.get(SysAimdx));
		motion.addMotion(90, (memory.get(SysUp) - memory.get(SysDn)));
		motion.addMotion(180, (memory.get(SysSx) - memory.get(SysDx)));

		if (energy > MAX_ENERGY)
		{
			double bodyChange = (energy - MAX_ENERGY) / 10;
			addBody(bodyChange);
			energy = MAX_ENERGY;
		}
		double bodyChange = (memory.get(SysStrbody) - memory.get(SysFdbody));
		bodyChange = Math.min(100, bodyChange);
		bodyChange = Math.max(-100, bodyChange);
		addBody(bodyChange);
		addEnergy(-(bodyChange * 10));
	}
}
