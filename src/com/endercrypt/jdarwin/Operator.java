package com.endercrypt.jdarwin;

import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public abstract class Operator
{
	private String name = getClass().getSimpleName();

	public Operator()
	{
		NamedOperator namedOperator = getClass().getAnnotation(NamedOperator.class);
		if (namedOperator != null)
		{
			name = namedOperator.value();
		}
	}

	public abstract void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot);

	@Override
	public String toString()
	{
		return name;
	}
}
