package com.endercrypt.jdarwin.compiler.operators.list.advanced;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Pyth extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int value1 = numberStack.pop();
		int value2 = numberStack.pop();
		value1 = value1 * value1;
		value2 = value2 * value2;
		int result = value1 + value2;
		result = (int) Math.sqrt(result);
		numberStack.push(result);
	}
}
