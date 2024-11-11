package zombie;

abstract class Unit {
	protected int pos;
	protected int hp;
	protected int damage;

	protected abstract void attack(Unit enenmy);
}
