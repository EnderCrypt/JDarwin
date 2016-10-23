package com.endercrypt.jdarwin.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.endercrypt.jdarwin.Operator;
import com.endercrypt.jdarwin.bot.Genome;
import com.endercrypt.jdarwin.compiler.operators.Operators;
import com.endercrypt.jdarwin.compiler.operators.special.MemoryLocation;
import com.endercrypt.jdarwin.compiler.operators.special.MemoryValue;
import com.endercrypt.jdarwin.compiler.operators.special.RawNumber;
import com.endercrypt.jdarwin.compiler.sysvar.Sysvars;

public class JDarwin
{
	public static final Operators operators = new Operators();

	public static final Sysvars sysvars = new Sysvars();

	private JDarwin()
	{

	}

	private static Operator compileOperator(String operator)
	{
		switch (OperatorType.of(operator))
		{
		case MEMORY_VALUE:
			return new MemoryValue(operator.substring(2));
		case MEMORY_LOCATION:
			return new MemoryLocation(operator.substring(1));
		case NUMBER:
			return new RawNumber(Integer.parseInt(operator));
		case OPERATOR:
			return operators.get(operator);
		}
		throw new UnknownOperatorException(operator);
	}

	public static Genome compile(String[][] stringOperators)
	{
		Operator[][] operators = new Operator[stringOperators.length][];
		for (int line = 0; line < stringOperators.length; line++)
		{
			String[] lineOperators = stringOperators[line];
			operators[line] = new Operator[lineOperators.length];
			for (int i = 0; i < lineOperators.length; i++)
			{
				operators[line][i] = compileOperator(lineOperators[i]);
			}
		}
		return new Genome(operators);
	}

	public static Genome compile(String code)
	{
		String[] lines = code.split("\n");
		String[][] operators = new String[lines.length][];
		for (int i = 0; i < lines.length; i++)
		{
			operators[i] = lines[i].split(" ");
		}
		return compile(operators);
	}

	public static Genome compile(File code) throws FileNotFoundException, IOException
	{
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(code)))
		{
			String line = br.readLine();
			while (line != null)
			{
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
		}
		return compile(sb.toString());
	}
}
