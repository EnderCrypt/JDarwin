package com.endercrypt.jdarwin;

import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Memory;
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

	public abstract void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, Memory memory, GenomeProcessor genomeProcessor);

	@Override
	public String toString()
	{
		return name;
	}
}
