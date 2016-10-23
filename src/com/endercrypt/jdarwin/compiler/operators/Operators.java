package com.endercrypt.jdarwin.compiler.operators;

import java.util.HashMap;
import java.util.Map;

import org.reflections.Reflections;

import com.endercrypt.jdarwin.NamedOperator;
import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.compiler.UnknownOperatorException;

public class Operators
{
	private Map<String, Operator> operators = new HashMap<>();

	public Operators()
	{
		loadOperators();
	}

	private void loadOperators()
	{
		Reflections reflections = new Reflections("com.endercrypt.jdarwin.compiler.operators.list");
		for (Class<? extends Operator> operatorClass : reflections.getSubTypesOf(Operator.class))
		{
			// name
			String name = operatorClass.getSimpleName();
			NamedOperator namedOperator = operatorClass.getAnnotation(NamedOperator.class);
			if (namedOperator != null)
			{
				name = namedOperator.value();
			}

			// operator
			Operator operator;
			try
			{
				operator = operatorClass.newInstance();
			}
			catch (InstantiationException | IllegalAccessException e)
			{
				throw new RuntimeException(e);
			}
			//System.out.println("Loaded operator \"" + name + "\" from class " + operatorClass.getSimpleName());
			operators.put(name.toLowerCase(), operator);
		}
	}

	public Operator get(String operatorName)
	{
		Operator operator = operators.get(operatorName.toLowerCase());
		if (operator == null)
			throw new UnknownOperatorException(operatorName);
		return operator;
	}

	public boolean exists(String operatorName)
	{
		return operators.containsKey(operatorName);
	}
}
