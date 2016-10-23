package com.endercrypt.jdarwin.compiler.operators.list.advanced;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Cos extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int value = numberStack.pop();
		double angle = value / 200;
		angle = Math.cos(angle);
		numberStack.push((int) (angle * 32_000));
	}
}
