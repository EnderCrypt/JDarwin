package com.endercrypt.jdarwin.compiler;

public enum OperatorType
{
	MEMORY_VALUE,
	MEMORY_LOCATION,
	NUMBER,
	OPERATOR;

	public static OperatorType of(String operatorString)
	{
		if (operatorString.startsWith("*."))
			return MEMORY_VALUE;
		if (operatorString.startsWith("."))
			return MEMORY_LOCATION;
		if (isNumber(operatorString))
			return NUMBER;
		if (JDarwin.operators.exists(operatorString))
			return OPERATOR;
		throw new UnknownOperatorException(operatorString);
	}

	private static boolean isNumber(String string)
	{
		boolean first = true;
		for (char c : string.toCharArray())
		{
			if ((c == '-') && (first))
				continue;
			if ((c < '0') || (c > '9'))
				return false;
		}
		return true;
	}
}
