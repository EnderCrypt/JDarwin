package com.endercrypt.jdarwin.bot;

import java.util.Iterator;

import com.endercrypt.jdarwin.Operator;

public class GenomeProcessor
{
	private Operator[][] operators;
	private Iterator<Operator> iterator;

	public GenomeProcessor(Operator[][] operators)
	{
		this.operators = operators;
		iterator = iterator();
	}

	private Iterator<Operator> iterator()
	{
		return new Iterator<Operator>()
		{
			int line = 0;
			int row = 0;

			@Override
			public boolean hasNext()
			{
				return (line < operators.length);
			}

			@Override
			public Operator next()
			{
				//if (hasNext() == false)
				//throw new NoSuchElementException();
				Operator[] operatorLine = operators[line];
				Operator operator = operatorLine[row];
				row++;
				if (row >= operatorLine.length)
				{
					line++;
					row = 0;
				}
				return operator;
			}
		};
	}

	public void process(Memory memory)
	{
		Stack<Integer> numberStack = new Stack<Integer>(0);
		Stack<Boolean> booleanStack = new Stack<Boolean>(true);

		while (iterator.hasNext())
		{
			Operator operator = iterator.next();
			operator.execute(numberStack, booleanStack, memory, this);
		}
	}

	public void skipUntill(Class<?> classType)
	{
		while (iterator.hasNext())
		{
			Operator operator = iterator.next();
			if (operator.getClass().equals(classType))
			{
				return;
			}
		}
	}
}
