package donkeykong.game;

public class Barrel extends EnemyObject {
	public Barrel(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}

	public String toString() {
		return super.toString() + "_Barrel";
	}
}
