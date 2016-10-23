package com.endercrypt.jdarwin.bot;

public class Stack<T>
{
	private static final int LIMIT = 20;

	private T defaultValue;
	private java.util.Stack<T> internalStack = new java.util.Stack<>();

	public Stack(T defaultValue)
	{
		this.defaultValue = defaultValue;
	}

	public void push(T value)
	{
		if (internalStack.size() < LIMIT)
		{
			internalStack.push(value);
		}
	}

	public T pop()
	{
		if (internalStack.size() > 0)
		{
			return internalStack.pop();
		}
		else
		{
			return defaultValue;
		}
	}

	public void clear()
	{
		internalStack.clear();
	}
}
