package com.endercrypt.jdarwin.compiler.operators.list.store;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Memory;
import com.endercrypt.jdarwin.bot.Stack;

public class SubStore extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, Memory memory, GenomeProcessor genomeProcessor)
	{
		int location = numberStack.pop();
		int value = numberStack.pop();
		int current = memory.get(location);
		memory.set(location, current - value);
	}
}
