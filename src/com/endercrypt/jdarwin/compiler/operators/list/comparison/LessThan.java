package com.endercrypt.jdarwin.compiler.operators.list.comparison;

import com.endercrypt.jdarwin.NamedOperator;
import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.bot.GenomeProcessor;
import com.endercrypt.jdarwin.bot.Stack;

@NamedOperator("<")
public class LessThan extends Operator
{
	@Override
	public void execute(Stack<Integer> numberStack, Stack<Boolean> booleanStack, GenomeProcessor genomeProcessor, Bot bot)
	{
		int value2 = numberStack.pop();
		int value1 = numberStack.pop();
		booleanStack.push(value1 < value2);
	}
}
