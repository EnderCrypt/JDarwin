package com.endercrypt.jdarwin.compiler.operators.list.flow;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Start extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		boolean activate = booleanStack.pop();
		if (activate == false)
		{
			genomeProcessor.skipUntill(Stop.class);
		}
	}
}
