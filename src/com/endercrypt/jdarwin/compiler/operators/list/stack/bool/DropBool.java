package com.endercrypt.jdarwin.compiler.operators.list.stack.bool;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class DropBool extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		booleanStack.pop();
	}
}
