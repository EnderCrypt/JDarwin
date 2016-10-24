package test;

import com.endercrypt.jdarwin.bot.Bot;
import com.endercrypt.jdarwin.compiler.JDarwin;

public class Main
{
	public static void main(String[] args)
	{
		Bot bot = new Bot(JDarwin.compile("cond start 5 2 add 16 store stop end"));
		bot.update();
		System.out.println(bot.getMemory());
	}
}
