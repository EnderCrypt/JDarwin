package com.endercrypt.jdarwin.compiler.operators.list.stack.bool;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class SwapBool extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		boolean value2 = booleanStack.pop();
		boolean value1 = booleanStack.pop();
		booleanStack.push(value1);
		booleanStack.push(value2);
	}
}
