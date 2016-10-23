package com.endercrypt.jdarwin.bot;

public class Memory
{
	private static final int MEMORY_LOCATIONS = 1000;
	private static final int MAX_VALUE = Short.MAX_VALUE;

	private int[] memory = new int[MEMORY_LOCATIONS];

	public Memory()
	{
		for (int i = 0; i < memory.length; i++)
		{
			memory[i] = 0;
		}
	}

	public void set(int location, int value)
	{
		if (isValidIndex(location))
		{
			location--;
			memory[location] = limitValue(value);
		}
	}

	public int get(int location)
	{
		if (isValidIndex(location))
		{
			location--;
			return memory[location];
		}
		return 0;
	}

	public int limitValue(int value)
	{
		return (value % MAX_VALUE);
	}

	public boolean isValidIndex(int location) // 1 to 1000
	{
		return ((location > 0) && (location <= MEMORY_LOCATIONS));
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000;)
		{
			sb.append(i + 1);
			for (int ii = 0; ii < 10; i++, ii++)
			{
				sb.append('\t');
				sb.append(memory[i]);
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
