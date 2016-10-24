package com.endercrypt.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiFrame
{
	private JFrame jFrame;
	private JPanel jPanel;

	private PaintCallback paintCallback;

	public GuiFrame()
	{
		jFrame = new JFrame();
		addPanel();
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

	private void addPanel()
	{
		jPanel = new JPanel()
		{
			@Override
			protected void paintComponent(java.awt.Graphics g)
			{
				super.paintComponent(g);
				paintCallback.PaintGui((Graphics2D) g);
				//paintGui((Graphics2D) g);
			};
		};
		jPanel.setBackground(Color.WHITE);
		jPanel.setPreferredSize(new Dimension(1000, 500));
		jFrame.add(jPanel);
		jFrame.pack();
	}

	public void repaint()
	{
		jFrame.repaint();
	}

	public void setPaintCallback(PaintCallback paintCallback)
	{
		this.paintCallback = paintCallback;
	}

	public Dimension getScreenSize()
	{
		return jPanel.getSize();
	}
}
