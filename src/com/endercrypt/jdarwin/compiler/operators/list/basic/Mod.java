package com.endercrypt.jdarwin.compiler.operators.list.basic;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Mod extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int value2 = numberStack.pop();
		int value1 = numberStack.pop();
		numberStack.push(value1 % value2);
	}
}
