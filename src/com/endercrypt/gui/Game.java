package com.endercrypt.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.BotInfo;
import com.endercrypt.jdarwin.compiler.JDarwin;
import com.endercrypt.jdarwin.compiler.JDarwinCompilationException;
import com.endercrypt.jdarwin.simulation.Simulation;
import com.endercrypt.library.position.Position;
import com.google.common.io.Files;

public class Game implements PaintCallback
{
	private boolean guiReady = false;
	private GuiFrame gui;
	private Camera camera;
	private Simulation simulation;

	private JDarwinCompilationException compilationFailure;

	public Game()
	{
		camera = new Camera();

		simulation = new Simulation();

		gui = new GuiFrame();
		gui.setPaintCallback(this);
		gui.activate();

		String dna;
		try
		{
			dna = Files.toString(new File("dna.txt"), Charset.defaultCharset());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		try
		{
			simulation.addBot(new Bot(JDarwin.compile(dna)));
		}
		catch (JDarwinCompilationException e)
		{
			compilationFailure = e;
		}
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
	public void paintGui(Graphics2D g2d)
	{
		Dimension screenSize = gui.getScreenSize();
		// world
		camera.translateGui(g2d, screenSize);
		g2d.setColor(Color.BLUE);
		for (Bot bot : simulation.getBots())
		{
			paintDarwinBot(g2d, bot.getBotInfo());
		}
		// gui
		camera.translateGuiForHud(g2d, screenSize);
		g2d.setColor(Color.BLACK);
		g2d.drawString(screenSize.width + ", " + screenSize.height, 10, 20);
		if (compilationFailure != null)
			g2d.drawString(compilationFailure.getClass().getSimpleName() + ": " + compilationFailure.getMessage(), 10, 40);

		// done
		guiReady = true;
	}

	private void paintDarwinBot(Graphics2D g2d, BotInfo botInfo)
	{
		Position position = botInfo.position;
		double rotation = botInfo.rotation.get();
		double frontX = (Math.cos(rotation) * 8);
		double frontY = (Math.sin(rotation) * 8);
		Line2D.Double line = new Line2D.Double(position.x, position.y, position.x + frontX, position.y + frontY);
		Ellipse2D.Double circle = new Ellipse2D.Double(position.x - 8.0, position.y - 8.0, 16.0, 16.0);
		g2d.draw(line);
		g2d.draw(circle);
	}
}
