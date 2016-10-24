package com.endercrypt.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.BotInfo;
import com.endercrypt.jdarwin.compiler.JDarwin;
import com.endercrypt.jdarwin.simulation.Simulation;
import com.google.common.io.Files;

import se.endercrypt.library.position.Position;

public class Game implements PaintCallback
{
	private boolean guiReady = false;
	private GuiFrame gui;
	private Camera camera;
	private Simulation simulation;

	public Game()
	{
		camera = new Camera();

		simulation = new Simulation();

		gui = new GuiFrame();
		gui.setPaintCallback(this);

		String dna;
		try
		{
			dna = Files.toString(new File("dna.txt"), Charset.defaultCharset());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		simulation.addBot(new Bot(JDarwin.compile(dna)));
	}

	public void update()
	{
		if (guiReady)
		{
			simulation.update();
			gui.repaint();
		}
	}

	@Override
	public void PaintGui(Graphics2D g2d)
	{
		Dimension screenSize = gui.getScreenSize();
		// world
		camera.translateGui(g2d, screenSize);
		g2d.setColor(Color.BLUE);
		for (Bot bot : simulation.getBots())
		{
			BotInfo info = bot.getBotInfo();
			Position position = info.position;
			g2d.drawOval((int) position.x, (int) position.y, 16, 16);
			int rel_x = (int) (Math.cos(info.rotation) * 8);
			int rel_y = (int) (Math.sin(info.rotation) * 8);
			g2d.drawLine((int) position.x + 8, (int) position.y + 8, (int) (position.x + 8 + rel_x), (int) (position.y + 8 + rel_y));
		}
		// gui
		camera.translateGuiForHud(g2d, screenSize);
		g2d.setColor(Color.BLACK);
		//g2d.drawString(gui.getScreenSize().toString(), 10, 20);

		// done
		guiReady = true;
	}
}
