package com.endercrypt.jdarwin.compiler.operators.list.advanced;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Dist extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int y = numberStack.pop();
		int x = numberStack.pop();
		x = (int) Math.pow(x, 2);
		y = (int) Math.pow(y, 2);
		int distance = (int) Math.sqrt(x + y);
		numberStack.push(distance);
	}
}
