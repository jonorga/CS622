package donkeykong.game;

public class Player extends GameObject {
	public Player(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}
	
	@Override
	public String toString() {
		return "Player";
	}
}
