package com.endercrypt.jdarwin.bot;

public class Bot
{
	private Genome genome;
	private Memory memory;

	public Bot(Genome genome)
	{
		this.genome = genome;
		memory = new Memory();
	}

	public void update()
	{
		genome.execute(memory);
		System.out.println(memory);
	}

	public Genome getGenome()
	{
		return genome;
	}

	public Memory getMemory()
	{
		return memory;
	}
}
