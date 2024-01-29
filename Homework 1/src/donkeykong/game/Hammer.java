package donkeykong.game;

public class Hammer extends GameObject{
	private boolean inUse;
	
	public Hammer(int xPosition, int yPosition) {
		super(xPosition, yPosition);
		inUse = false;
	}
	
	public boolean getInUse() {
		return inUse;
	}
	
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
	public String toString() {
		return "Hammer";
	}
}
