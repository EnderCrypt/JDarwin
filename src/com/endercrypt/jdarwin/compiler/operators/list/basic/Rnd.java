package com.endercrypt.jdarwin.compiler.operators.list.basic;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Rnd extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int max = numberStack.pop();
		int value = (int) Math.round(Math.random() * max);
		numberStack.push(value);
	}
}
