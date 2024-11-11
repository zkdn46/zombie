package zombie;

import java.util.Scanner;

public class Play {
	private final int MOVE = 1;
	private final int EXIT = 2;

	protected Scanner sc = new Scanner(System.in);
	private Hero hero;
	private Boss boss;
	private Zombie zombie;
	private boolean isRun = true;

	public void run() {
		set();
		while (isRun) {
			play();
			end();
		}
	}

	private void set() {
		zombie = new Zombie(5, 10, 100);
		boss = new Boss(9, 20, 300, 100);
		hero = new Hero(1, 20, 200, 2);
	}

	private void play() {
		System.out.println("현재 위치: " + hero.pos);
		int sel = input("앞으로 이동(1), 종료(2)");

		if (sel < MOVE || sel > EXIT) {
			System.out.println("1 또는 2 입력!");
			return;
		}

		if (sel == MOVE) {

		} else if (sel == EXIT) {
			exit();
		}
	}

	private void exit() {
		isRun = false;
		System.out.println("게임 종료.");
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
