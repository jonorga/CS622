package donkeykong.game;

public class GameObject {
	int xPosition;
	int yPosition;
	
	public GameObject(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	@Override
	public String toString() {
		return "GameObject";
	}
}
