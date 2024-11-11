package zombie;

public class Zombie extends Unit {

	protected Zombie(int pos, int maxDamage, int hp) {
		super.pos = pos;
		super.maxDamage = maxDamage;
		super.hp = hp;
	}

	protected void attack(Unit hero) {
		int damage = ran.nextInt(maxDamage) + 1;
		hero.hp -= damage;
		if (hero.hp < 0) {
			hero.hp = 0;
		}
		hp += damage / 2;

		String msg = String.format("좀비가 %d의 피해를 입힘, 현재 Hero체력: %d", damage, hero.hp);
		System.out.println(msg);
		msg = String.format("좀비 체력 회복, 현재 좀비 체력: %d", hp);
		System.out.println(msg);
	}

}