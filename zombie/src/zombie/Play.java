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
			printMenu();
			play();
			end();
		}
	}

	private void set() {
		zombie = new Zombie(5, 10, 100);
		boss = new Boss(9, 20, 300, 100);
		hero = new Hero(1, 20, 200, 2);
	}

	private void printMenu() {
		System.out.println("현재 위치: " + hero.pos);
		System.out.println("앞으로 이동(1), 종료(2)");
	}

	private void end() {
		if (boss.hp == 0) {
			System.out.println("보스 사망, Clear~");
			isRun = false;
		} else if (hero.hp == 0) {
			System.out.println("Hero 사망, 패배~");
			isRun = false;
		}
	}

	private int input(String msg) {
		System.out.println(msg + ": ");

		String sel = "";
		int number = -1;

		try {
			sel = sc.nextLine();
			number = Integer.parseInt(sel);
			return number;
		} catch (Exception e) {
			System.err.println("숫자 입력!");
			return number;
		}

	}
}
