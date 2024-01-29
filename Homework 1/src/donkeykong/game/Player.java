package donkeykong.game;

public class Player extends GameObject {
	private Hammer hammer;
	
	public Player(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}
	
	public void setHammer(Hammer hammer) {
		this.hammer = hammer;
	}
	
	@Override
	public String toString() {
		return "Player";
	}
}
