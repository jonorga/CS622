package donkeykong.game;

public class GameArea {
	private GameObject[][] board = new GameObject[10][10];
	private GameManager gameManager;
	
	public GameArea(GameManager gameManager) {
		this.gameManager = gameManager;
	}
	
	public void moveGameObject(GameObject gameObject) {
		if (board[gameObject.yPosition][gameObject.xPosition] != null)
			gameManager.collision(gameObject, board[gameObject.yPosition][gameObject.xPosition]);
		else
			board[gameObject.yPosition][gameObject.xPosition] = gameObject;
	}
	
	public void placeGameObject(GameObject gameObject) {
		board[gameObject.yPosition][gameObject.xPosition] = gameObject;
		System.out.println(gameObject.toString() + " placed on board at " + gameObject.yPosition
				+ ", " + gameObject.xPosition);
	}
}
