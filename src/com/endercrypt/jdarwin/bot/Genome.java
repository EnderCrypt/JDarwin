package com.endercrypt.jdarwin.bot;

import com.endercrypt.jdarwin.Operator;

public class Genome
{
	private Operator[][] operators;

	public Genome(Operator[][] operators)
	{
		this.operators = operators;
	}

	protected void execute(Bot bot)
	{
		GenomeProcessor genomeProcessor = new GenomeProcessor(operators);
		genomeProcessor.process(bot);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (Operator[] line : operators)
		{
			for (Operator operator : line)
			{
				sb.append(operator);
				sb.append(' ');
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
