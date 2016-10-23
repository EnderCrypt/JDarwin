package com.endercrypt.jdarwin.compiler.operators.list.advanced;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Pow extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int power = numberStack.pop();
		int value = numberStack.pop();
		value = (int) Math.pow(value, power);
		numberStack.push(value);
	}
}
