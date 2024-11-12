package zombie;

public class Mage extends Zombie {

	protected int mana;

	protected Mage(int pos, int maxDamage, int hp, int mana) {
		super(pos, maxDamage, hp);
		this.mana = mana;
	}

	protected void attack(Unit hero) {
		int damage = ran.nextInt(maxDamage) + 1;

		int magic = ran.nextInt(3);
		if (magic == 1 && mana >= 20) {
			hero.hp -= damage * 3;
			mana -= 20;
			String msg = String.format("마법 공격! 마법사가 %d의 피해를 입힘, ", damage * 3);
			System.out.print(msg);
		} else if (magic == 2 && mana <= 40) {
			mana += 10;
			System.out.print("마나 회복! 마법사가 10의 마나 회복, ");
		} else {
			hero.hp -= damage;
			String msg = String.format("마법사가 %d의 피해를 입힘, ", damage);
			System.out.print(msg);
		}

		if (hero.hp < 0) {
			hero.hp = 0;
		}

		String msg = String.format("현재 Hero체력: %d", hero.hp);
		System.out.println(msg);
	}

}
