package donkeykong.game;

public class Fireball extends EnemyObject {
	public Fireball(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}

	public String toString() {
		return super.toString() + "_Fireball";
	}
}
