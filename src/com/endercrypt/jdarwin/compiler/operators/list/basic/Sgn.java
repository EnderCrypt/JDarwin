package com.endercrypt.jdarwin.compiler.operators.list.basic;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Sgn extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int value = numberStack.pop();
		int result = 0;
		if (value > 0)
			result = 1;
		if (value < 0)
			result = -1;
		numberStack.push(result);
	}
}
