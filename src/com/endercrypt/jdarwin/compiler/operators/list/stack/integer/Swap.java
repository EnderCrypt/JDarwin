package com.endercrypt.jdarwin.compiler.operators.list.stack.integer;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Memory;
import com.endercrypt.jdarwin.bot.Stack;

public class Swap extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, Memory memory, GenomeProcessor genomeProcessor)
	{
		int value2 = numberStack.pop();
		int value1 = numberStack.pop();
		numberStack.push(value1);
		numberStack.push(value2);
	}
}
