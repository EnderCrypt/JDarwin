package test;

import java.util.Timer;
import java.util.TimerTask;

import com.endercrypt.gui.Game;

public class Main
{
	private static Timer timer = new Timer();
	private static Game game;

	public static void main(String[] args)
	{
		game = new Game();

		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				game.update();
			}
		}, 20, 20);
	}
}
