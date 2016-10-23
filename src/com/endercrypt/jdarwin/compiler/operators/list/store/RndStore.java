package com.endercrypt.jdarwin.compiler.operators.list.store;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Memory;
import com.endercrypt.jdarwin.bot.Stack;

public class RndStore extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		Memory memory = bot.getMemory();
		int location = numberStack.pop();
		int value = memory.get(location);
		int result = (int) Math.round(Math.random() * value);
		memory.set(location, result);
	}
}
