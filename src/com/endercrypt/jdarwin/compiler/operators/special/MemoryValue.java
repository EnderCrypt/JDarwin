package com.endercrypt.jdarwin.compiler.operators.special;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;
import com.endercrypt.jdarwin.compiler.JDarwin;

public class MemoryValue extends Operator
{
	private final String location;
	private final int memoryLocation;

	public MemoryValue(String location)
	{
		this.location = location;
		memoryLocation = JDarwin.sysvars.get(location);
	}

	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int value = bot.getMemory().get(memoryLocation);
		numberStack.push(value);
	}

	@Override
	public String toString()
	{
		return "*." + location;
	}
}
