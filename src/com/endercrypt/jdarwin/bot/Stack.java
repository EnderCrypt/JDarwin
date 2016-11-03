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
		if (internalStack.size() == LIMIT)
		{
			internalStack.remove(0);
		}
		internalStack.push(value);
	}

	public T pop()
	{
		if (internalStack.empty())
		{
			return defaultValue;
		}
		return internalStack.pop();
	}

	public T peek()
	{
		if (internalStack.empty())
		{
			return defaultValue;
		}
		return internalStack.peek();
	}

	public void clear()
	{
		internalStack.clear();
	}
}
