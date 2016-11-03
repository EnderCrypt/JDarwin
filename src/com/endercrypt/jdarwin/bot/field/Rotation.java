package com.endercrypt.jdarwin.bot.field;

public class Rotation
{
	public static final double QUARTER_CIRCLE = Math.PI / 2;
	public static final double HALF_CIRCLE = Math.PI;
	public static final double FULL_CIRCLE = Math.PI * 2;

	public static final int QUARTER_DARWIN_CIRCLE = (int) (QUARTER_CIRCLE * 200);
	public static final int HALF_DARWIN_CIRCLE = (int) (HALF_CIRCLE * 200);
	public static final int FULL_DARWIN_CIRCLE = (int) (FULL_CIRCLE * 200);

	private double rotation;

	public Rotation(double rotation)
	{
		set(rotation);
	}

	public void increaseDarwinRotation(int by)
	{
		set(rotation - (by / 200.0));
	}

	public int getDarwinRotation()
	{
		int darwinRotation = (int) (FULL_DARWIN_CIRCLE - (rotation * 200));
		if (darwinRotation == FULL_DARWIN_CIRCLE)
			darwinRotation = 0;
		return darwinRotation;
	}

	public void set(double rotation)
	{
		this.rotation = rotation % FULL_CIRCLE;
		if (this.rotation < 0)
		{
			int below = (int) (this.rotation / FULL_CIRCLE) + 1;
			this.rotation += below * FULL_CIRCLE;
		}
	}

	public double get()
	{
		return rotation;
	}
}
