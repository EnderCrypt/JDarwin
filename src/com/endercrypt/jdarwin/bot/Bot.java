package com.endercrypt.jdarwin.bot;

public class Bot
{
	private Genome genome;
	private Memory memory;
	private BotInfo botInfo;

	public Bot(Genome genome)
	{
		this.genome = genome;
		memory = new Memory();
		botInfo = new BotInfo();
	}

	public void update()
	{
		botInfo.preUpdate(this);
		genome.execute(this);
		botInfo.postUpdate(this);
	}

	public Genome getGenome()
	{
		return genome;
	}

	public Memory getMemory()
	{
		return memory;
	}

	public BotInfo getBotInfo()
	{
		return botInfo;
	}
}
