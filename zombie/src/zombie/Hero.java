package zombie;

public class Hero extends Unit {
	protected int potion;

	protected Hero(int pos, int maxDamage, int hp, int potion) {
		super.pos = pos;
		super.maxDamage = maxDamage;
		super.hp = hp;
		this.potion = potion;
	}

	protected void attack(Unit enenmy) {
		int damage = ran.nextInt(maxDamage) + 1;

		if (enenmy instanceof Boss) {
			if (((Boss) enenmy).shield != 0) {
				((Boss) enenmy).shield -= damage;
				if (((Boss) enenmy).shield <= 0) {
					((Boss) enenmy).shield = 0;
					System.out.println("보스 실드 파괴!");
				}
			} else {
				enenmy.hp -= damage;
				if (enenmy.hp < 0) {
					enenmy.hp = 0;
				}
			}
			String msg = String.format("보스에게 %d의 피해 입힘, 현재 보스 체력: %d / 실드: %d", damage, enenmy.hp,
					((Boss) enenmy).shield);
			System.out.println(msg);
		} else {
			enenmy.hp -= damage;
			String msg = String.format("좀비에게 %d의 피해 입힘, 현재 좀비 체력: %d", damage, enenmy.hp);
			System.out.println(msg);
		}

	}

}
