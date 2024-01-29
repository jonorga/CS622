package donkeykong.game;

public class GameObject {
	int xPosition;
	int yPosition;
	
	public GameObject(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public void setCoordinates(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public void destroySelf() {
		
	}
	
	@Override
	public String toString() {
		return "GameObject";
	}
}
