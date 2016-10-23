package com.endercrypt.jdarwin.compiler.sysvar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Sysvars
{
	private Map<String, Integer> sysvars = new HashMap<>();

	public Sysvars()
	{
		loadSysvars();
	}

	private void loadSysvars()
	{
		File sysvarFile = new File("data/sysvar.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(sysvarFile)))
		{
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				int location = Integer.parseInt(reader.readLine());
				sysvars.put(line, location);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public int get(String name)
	{
		Integer location = sysvars.get(name.toLowerCase());
		if (location == null)
			throw new UnknownSysvarException(name);
		return location;
	}

	public boolean exists(String name)
	{
		return sysvars.containsKey(name.toLowerCase());
	}
}
