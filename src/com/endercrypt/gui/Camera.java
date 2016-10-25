package com.endercrypt.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;

import com.endercrypt.library.position.Motion;
import com.endercrypt.library.position.Position;

public class Camera
{
	private Position position = new Position();
	private Motion motion = new Motion();

	private Position translation;

	public Camera()
	{

	}

	public void update()
	{
		position.add(motion);
		motion.multiplyLength(0.9);
	}

	public void translateGui(Graphics2D g2d, Dimension screenSize)
	{
		translation = new Position(position.x + (screenSize.width / 2), position.y + (screenSize.height / 2));
		g2d.translate(translation.x, translation.y);
	}

	public void translateGuiForHud(Graphics2D g2d, Dimension screenSize)
	{
		g2d.translate(-translation.x, -translation.y);
	}
}
