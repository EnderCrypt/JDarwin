package com.endercrypt.jdarwin.compiler.operators.special;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class RawNumber extends Operator
{
	public final int value;

	public RawNumber(int value)
	{
		this.value = value;
	}

	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		numberStack.push(value);
	}

	@Override
	public String toString()
	{
		return Integer.toString(value);
	}
}
