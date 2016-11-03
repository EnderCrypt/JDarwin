package com.endercrypt.jdarwin.simulation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.endercrypt.jdarwin.bot.Bot;

public class Simulation
{
	private Set<Bot> bots = new HashSet<>();
	private Set<Bot> immutableBotSet = Collections.unmodifiableSet(bots);
	private Set<Bot> newBots = new HashSet<>();

	public void update()
	{
		// add new bots
		bots.addAll(newBots);
		newBots.clear();
		// loop
		Iterator<Bot> iterator = bots.iterator();
		while (iterator.hasNext())
		{
			Bot bot = iterator.next();
			bot.update(this);
			if (bot.getBotInfo().energy.get() <= 0)
			{
				iterator.remove();
			}
		}
	}

	public void addBot(Bot bot)
	{
		newBots.add(bot);
	}

	public Set<Bot> getBots()
	{
		return immutableBotSet;
	}
}
