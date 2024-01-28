package donkeykong.game;

public class GameArea {
	private GameObject[][] board = new GameObject[10][10];
	private GameManager gameManager;
	
	public GameArea(GameManager gameManager) {
		this.gameManager = gameManager;
	}
	
	public void moveGameObject(GameObject gameObject, int xPosition, int yPosition) {
		if (board[yPosition][xPosition] != null) {
			System.out.println("Collision between " + gameObject.toString() + " and " + 
					board[yPosition][xPosition].toString());
			gameManager.collision(gameObject, board[yPosition][xPosition]);
		}
		else {
			board[gameObject.yPosition][gameObject.xPosition] = null;
			gameObject.setCoordinates(xPosition, yPosition);
			MoveGameObject(gameObject);
		}
	}
	
	private void MoveGameObject(GameObject gameObject) {
		board[gameObject.yPosition][gameObject.xPosition] = gameObject;
		System.out.println(gameObject.toString() + " moved to " + gameObject.yPosition + ", " +
				gameObject.xPosition);
	}
	
	public void placeGameObject(GameObject gameObject) {
		board[gameObject.yPosition][gameObject.xPosition] = gameObject;
		System.out.println(gameObject.toString() + " placed on board at " + gameObject.yPosition
				+ ", " + gameObject.xPosition);
	}
}
