package donkeykong.game;

public class GameManager {
	private GameArea gameArea;
	private Player player;
	private Enemy enemy;
	private int score;

	public GameManager() {
		gameArea = new GameArea(this);
		player = new Player(0, 0);
		enemy = new Enemy(0, 9);
		score = 0;
		gameArea.placeGameObject(player);
		gameArea.placeGameObject(enemy);
	}
	
	public void update() {
		
	}
	
	public void collision(GameObject gameObject1, GameObject gameObject2) {
		
	}

	public void gameOver() {
		
	}
}
