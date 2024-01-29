package donkeykong.game;

public class Barrel extends EnemyObject {
	private String barrelType;
	
	public Barrel(int xPosition, int yPosition, String barrelType) {
		super(xPosition, yPosition);
		this.barrelType = barrelType;
	}

	public String toString() {
		return super.toString() + "_Barrel" + barrelType;
	}
}
