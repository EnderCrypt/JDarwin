package com.endercrypt.jdarwin.compiler.operators.list.logic;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class And extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		boolean value1 = booleanStack.pop();
		boolean value2 = booleanStack.pop();
		booleanStack.push(value1 && value2);
	}
}
