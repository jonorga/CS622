package donkeykong.game;

public class Enemy extends GameObject {
	public Enemy(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}
	
	@Override
	public String toString() {
		return "Enemy";
	}
}
