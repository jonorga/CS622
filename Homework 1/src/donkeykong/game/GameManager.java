package donkeykong.game;

public class GameManager {
	private GameArea gameArea;
	private int score;

	public GameManager() {
		gameArea = new GameArea(this);
		score = 0;
		gameArea.placeGameObject(new Player(0, 0));
		gameArea.placeGameObject(new Enemy(0, 9));
	}
	
	public void update() {
		
	}
	
	public void collision(GameObject gameObject1, GameObject gameObject2) {
		
	}

	public void gameOver() {
		
	}
}
