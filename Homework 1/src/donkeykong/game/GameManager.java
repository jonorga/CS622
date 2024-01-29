package donkeykong.game;

public class GameManager {
	private GameArea gameArea;
	private Player player;
	private Enemy enemy;
	private Hammer hammer;
	private int score;

	public GameManager() {
		System.out.println("\nInitializing game setup...");
		score = 0;
		gameArea = new GameArea(this);
		
		player = new Player(1, 0);
		enemy = new Enemy(0, 9);
		hammer = new Hammer(0, 5);
		
		gameArea.placeGameObject(player);
		gameArea.placeGameObject(enemy);
		gameArea.placeGameObject(hammer);
		System.out.println("Game setup complete...\n");
	}
	
	public void movePlayer(int direction) {
		if (direction == 0) {
			if (player.xPosition > 0)
				gameArea.moveGameObject(player, player.xPosition - 1, player.yPosition);
		}
		else if (direction == 1) {
			if (player.yPosition < 9)
				gameArea.moveGameObject(player, player.xPosition, player.yPosition + 1);
		}
		else if (direction == 2) {
			if (player.xPosition < 9)
				gameArea.moveGameObject(player, player.xPosition + 1, player.yPosition);
		}
		else if (direction == 3) {
			if (player.yPosition > 0)
				gameArea.moveGameObject(player, player.xPosition, player.yPosition - 1);
		}
	}
	
	public boolean collision(GameObject gameObject1, GameObject gameObject2) {
		String gameObject1Name = gameObject1.toString();
		String gameObject2Name = gameObject2.toString();
		if (gameObject1Name.equals("Player") || gameObject2Name.equals("Player")) {
			if (gameObject1Name.indexOf("Enemy") != -1 || gameObject2Name.indexOf("Enemy") != -1) {
				gameOver();
				return true;
			}
			else if (gameObject1Name.equals("Player") && gameObject2Name.equals("Hammer")) {
				((Player)gameObject1).setHammer((Hammer)gameObject2);
				((Hammer)gameObject2).setInUse(true);
			}
			else if (gameObject2Name.equals("Player") && gameObject1Name.equals("Hammer")) {
				((Player)gameObject2).setHammer((Hammer)gameObject1);
				((Hammer)gameObject1).setInUse(true);
			}
		}
		else if (gameObject1Name.equals("Hammer") || gameObject2Name.equals("Hammer")) {
			boolean hammerHitEnemyObject = false;
			String enemyObjectName = "";
			if (gameObject1Name.equals("Hammer") && ((Hammer)gameObject1).getInUse()) {
				if (gameObject2Name.indexOf("Enemy") != -1) {
					enemyObjectName = gameObject2Name;
					gameArea.destroyGameObject(gameObject2);
					hammerHitEnemyObject = true;
				}
			}
			else if (gameObject2Name.equals("Hammer") && ((Hammer)gameObject2).getInUse()) {
				if (gameObject1Name.indexOf("Enemy") != -1) {
					enemyObjectName = gameObject1Name;
					gameArea.destroyGameObject(gameObject1);
					hammerHitEnemyObject = true;
				}
			}
			if (hammerHitEnemyObject) {
				score += 100;
				System.out.println("Hammer destroyed " + enemyObjectName + " (+100 points)");
				return false;
			}
		}
		return false;
	}

	public void gameOver() {
		
	}
}
