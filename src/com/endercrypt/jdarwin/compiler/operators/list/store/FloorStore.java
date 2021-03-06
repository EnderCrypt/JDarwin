package com.endercrypt.jdarwin.compiler.operators.list.store;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Memory;
import com.endercrypt.jdarwin.bot.Stack;

public class FloorStore extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		Memory memory = bot.getMemory();
		int location = numberStack.pop();
		int min = numberStack.pop();
		int current = memory.get(location);
		if (current < min)
			current = min;
		memory.set(location, current);
	}
}
