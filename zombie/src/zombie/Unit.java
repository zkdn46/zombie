package zombie;

import java.util.Random;

abstract class Unit {
	protected Random ran = new Random();
	
	protected int pos;
	protected int hp;
	protected int maxDamage;

	protected abstract void attack(Unit enenmy);
}
