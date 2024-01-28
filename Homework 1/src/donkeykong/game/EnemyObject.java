package donkeykong.game;

public abstract class EnemyObject extends GameObject {
	public EnemyObject(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}
	
	@Override
	public String toString() {
		return "EnemyObject";
	}
}
