package donkeykong.game;

public class GameArea {
	private GameObject[][] board = new GameObject[10][10];
	private GameManager gameManager;
	
	public GameArea(GameManager gameManager) {
		this.gameManager = gameManager;
	}
	
	public void moveGameObject(GameObject gameObject, int xPosition, int yPosition) {
		if (board[yPosition][xPosition] != null) {
			if (!gameManager.collision(gameObject, board[yPosition][xPosition])) {
				board[gameObject.yPosition][gameObject.xPosition] = null;
				gameObject.setCoordinates(xPosition, yPosition);
				MoveGameObject(gameObject);
			}
			else {
				System.out.println("Collision between " + gameObject.toString() + " and " + 
						board[yPosition][xPosition].toString());
			}
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
		if (board[gameObject.yPosition][gameObject.xPosition] != null) {
			System.out.println("Failed to place " + gameObject.toString() + " because " +
					board[gameObject.yPosition][gameObject.xPosition].toString() + 
					" already occupies that spot");
			return;
		}
		board[gameObject.yPosition][gameObject.xPosition] = gameObject;
		System.out.println(gameObject.toString() + " placed on board at " + gameObject.yPosition
				+ ", " + gameObject.xPosition);
	}
	
	public void destroyGameObject(GameObject gameObject) {
		board[gameObject.yPosition][gameObject.xPosition] = null;
	}
}
