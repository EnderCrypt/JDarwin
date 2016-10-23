package com.endercrypt.jdarwin.compiler.operators.list.store;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Memory;
import com.endercrypt.jdarwin.bot.Stack;

public class SgnStore extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		Memory memory = bot.getMemory();
		int location = numberStack.pop();
		int value = memory.get(location);
		int result = 0;
		if (value > 0)
			result = 1;
		if (value < 0)
			result = -1;
		memory.set(location, result);
	}
}
