package com.endercrypt.jdarwin.compiler.operators.list.stack.integer;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

public class Dup extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int value = numberStack.pop();
		numberStack.push(value);
		numberStack.push(value);
	}
}
