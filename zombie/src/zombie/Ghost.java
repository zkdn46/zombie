package zombie;

public class Ghost extends Zombie {

	protected Ghost(int pos, int maxDamage, int hp) {
		super(pos, maxDamage, hp);
	}
	
	protected void attack(Unit hero) {
		int damage = ran.nextInt(maxDamage) + 1;
		hero.hp -= damage;
		if (hero.hp < 0) {
			hero.hp = 0;
		}

		String msg = String.format("유령이 %d의 피해를 입힘, 현재 Hero체력: %d", damage, hero.hp);
		System.out.println(msg);
	}
	
}
