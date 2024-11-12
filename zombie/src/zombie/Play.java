package zombie;

import java.util.Random;
import java.util.Scanner;

public class Play {
	private final int MOVE = 1;
	private final int EXIT = 2;

	private final int EMPTY = 0;
	private final int ATTACK = 1;
	private final int POTION = 2;

	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	private Hero hero;
	private Zombie zombie;
	private Ghost ghost;
	private Mage mage;
	private Boss boss;

	private boolean isRun = true;

	public void run() {
		set();
		while (isRun) {
			play();
		}
		end();
	}

	private void set() {
		hero = new Hero(1, 20, 250, 1);
		zombie = new Zombie(3, 5, 150);
		ghost = new Ghost(5, 10, 100);
		mage = new Mage(7, 15, 100, 50);
		boss = new Boss(9, 20, 200, 50);
	}

	private void play() {
		System.out.println("현재 위치: " + hero.pos);
		int sel = input("앞으로 이동(1), 종료(2)");

		if (sel < MOVE || sel > EXIT) {
			System.out.println("1 또는 2 입력!");
			return;
		}

		if (sel == MOVE) {
			move();
		} else if (sel == EXIT) {
			exit();
		}
	}

	private void move() {
		hero.pos++;

		if (hero.pos == zombie.pos) {
			zombieBattle();
		} else if (hero.pos == ghost.pos) {
			ghostBattle();
		} else if (hero.pos == mage.pos) {
			mageBattle();
		} else if (hero.pos == boss.pos) {
			bossBattle();
		}
	}

	private void zombieBattle() {
		System.out.println("좀비를 만났다!");
		while (true) {
			int sel = input("공격(1), 포션마시기(2)");

			if (sel < ATTACK || sel > POTION) {
				System.out.println("1 또는 2 입력!");
				continue;
			}

			battle(zombie, sel);

			if (zombie.hp == EMPTY) {
				System.out.println("좀비 처치");
				getPotion();
				break;
			} else if (hero.hp == EMPTY) {
				isRun = false;
				break;
			}
		}

	}

	private void ghostBattle() {
		System.out.println("유령을 만났다!");
		while (true) {
			int sel = input("공격(1), 포션마시기(2)");

			if (sel < ATTACK || sel > POTION) {
				System.out.println("1 또는 2 입력!");
				continue;
			}

			battle(ghost, sel);

			if (ghost.hp == EMPTY) {
				System.out.println("유령 처치!");
				getPotion();
				break;
			} else if (hero.hp == EMPTY) {
				break;
			}
		}
	}

	private void mageBattle() {
		System.out.println("마법사를 만났다!");
		while (true) {
			int sel = input("공격(1), 포션마시기(2)");

			if (sel < ATTACK || sel > POTION) {
				System.out.println("1 또는 2 입력!");
				continue;
			}

			battle(mage, sel);

			if (mage.hp == EMPTY) {
				System.out.println("마법사 처치!");
				getPotion();
				break;
			} else if (hero.hp == EMPTY) {
				break;
			}
		}
	}

	private void bossBattle() {
		System.out.println("보스를 만났다!");
		while (true) {
			int sel = input("공격(1), 포션마시기(2)");

			if (sel < ATTACK || sel > POTION) {
				System.out.println("1 또는 2 입력!");
				continue;
			}

			battle(boss, sel);

			if (boss.hp == EMPTY) {
				isRun = false;
				break;
			} else if (hero.hp == EMPTY) {
				isRun = false;
				break;
			}
		}
	}

	void battle(Unit unit, int sel) {
		if (sel == ATTACK) {
			unit.attack(hero);
			hero.attack(unit);

		} else if (sel == POTION) {
			if (hero.potion != EMPTY) {
				unit.attack(hero);
			}
			hero.recovery();
		}
	}

	private void getPotion() {
		int qty = ran.nextInt(2);
		hero.potion += qty;

		if (qty == 1) {
			System.out.println("Hero 포션 1개 획득");
		}
	}

	private void exit() {
		isRun = false;
		System.out.println("게임 종료.");
	}

	private void end() {
		if (boss.hp == EMPTY) {
			System.out.println("보스 처치, Clear~");
		} else if (hero.hp == EMPTY) {
			System.out.println("Hero 사망, 패배~");
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
