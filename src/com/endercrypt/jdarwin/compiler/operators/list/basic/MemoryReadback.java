package com.endercrypt.jdarwin.compiler.operators.list.basic;

import com.endercrypt.jdarwin.NamedOperator;
import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Memory;
import com.endercrypt.jdarwin.bot.Stack;

@NamedOperator("*")
public class MemoryReadback extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, Memory memory, GenomeProcessor genomeProcessor)
	{
		int location = numberStack.pop();
		if (memory.isValidIndex(location))
		{
			int value = memory.get(location);
			numberStack.push(value);
		}
	}
}
