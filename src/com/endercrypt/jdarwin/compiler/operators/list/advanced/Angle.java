package com.endercrypt.jdarwin.compiler.operators.list.advanced;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Angle extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int y = numberStack.pop();
		int x = numberStack.pop();
		int angle = (int) (Math.atan2(y, x) * 200.0);
		numberStack.push(angle);
	}
}
