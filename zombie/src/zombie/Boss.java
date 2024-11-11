package zombie;

public class Boss extends Unit {
	protected final int DOUBLE = 2;

	protected int shield;

	protected Boss(int pos, int maxDamage, int hp, int shield) {
		super.pos = pos;
		super.maxDamage = maxDamage;
		super.hp = hp;
		this.shield = shield;
	}

	protected void attack(Unit hero) {
		int damage = ran.nextInt(maxDamage) + 1;

		int critical = ran.nextInt(4);
		if (critical == DOUBLE) {
			hero.hp -= damage * DOUBLE;
			String msg = String.format("필살기! Hero에게 %d의 치명타 피해 입힘, 현재 Hero 체력: %d", damage * DOUBLE, hp);
			System.out.println(msg);
		} else {
			hero.hp -= damage;
			String msg = String.format("Hero에게 %d의 피해 입힘, 현재 Hero 체력: %d", damage, hp);
			System.out.println(msg);
		}

		if (hero.hp < EMPTY) {
			hero.hp = EMPTY;
		}

	}

}
