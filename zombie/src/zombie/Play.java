package zombie;

import java.util.Scanner;

public class Play {
	protected Scanner sc = new Scanner(System.in);
	private Hero hero;
	private Boss boss;
	private Zombie zombie;
	private boolean isRun = true;

	public void run() {
		set();
		while (isRun) {

			end();
		}
	}

	private void set() {
		zombie = new Zombie(5, 10, 100);
		boss = new Boss(9, 20, 300, 100);
		hero = new Hero(0, 20, 200, 2);
	}

	private void end() {

	}
}
