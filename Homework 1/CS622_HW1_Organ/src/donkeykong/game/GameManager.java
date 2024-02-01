/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: GameManager.java
 * Description: This file contains the GameManager class. This class acts as the main facilitator for all the other
 * objects in the game. It has variables containing the game area, player, enemy, and hammer objects. It also keeps
 * track of score.
 */

package donkeykong.game;

public class GameManager {
	private GameArea gameArea;
	private Player player;
	private Enemy enemy;
	private Hammer hammer;
	private boolean firstBarrel;
	private int score;
	
	
	/**
     * This is the constructor method that sets up the game. It initializes the score and various game objects
     * and places them onto the board.
     */
	public GameManager() {
		System.out.println("\nInitializing game setup...");
		score = 0;
		firstBarrel = true;
		gameArea = new GameArea(this);
		
		player = new Player(1, 0, gameArea);
		enemy = new Enemy(0, 9, gameArea);
		hammer = new Hammer(0, 5, gameArea);
		
		gameArea.placeGameObject(player);
		gameArea.placeGameObject(enemy);
		gameArea.placeGameObject(hammer);
		System.out.println("Game setup complete...\n\nGame running...");
	}
	
	/**
     * This method calls the update method on all game objects in the game area
     */
	public void updateGameArea() {
		gameArea.updateAll();
	}
	
	/**
     * This method throws a barrel from the enemy. As per the game, the first barrel is blue, and all the barrels
     * afterwards are red. 
     */
	public void enemyThrowBarrel() {
		gameArea.updateAll();
		if (firstBarrel) {
			enemy.throwBarrel("Blue");
			firstBarrel = false;
		} else {
			enemy.throwBarrel("Red");
		}
	}
	
	/**
     * This method handles player movement. It takes an int as a parameter to determine which direction to move in.
     * It does block the player if they try to move outside of the game area. It also moves the hammer and checks
     * if the player reached the goal location.
     */
	public void movePlayer(int direction) {
		gameArea.updateAll();
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
		if (player.hasHammer())
			player.updateHammer();
		if (player.yPosition == 9 && player.xPosition == 2)
			gameWin();
	}
	
	/**
     * This method is called by the game area any time two objects try to occupy the same space. It returns a boolean to 
     * determine whether that move is allowed based on which two objects collided.
     * @return boolean
     */
	public boolean collision(GameObject gameObject1, GameObject gameObject2) {
		String gameObject1Name = gameObject1.toString();
		String gameObject2Name = gameObject2.toString();
		if (gameObject1Name.equals("Player") || gameObject2Name.equals("Player")) {
			if (gameObject1Name.indexOf("Enemy") != -1 || gameObject2Name.indexOf("Enemy") != -1) {
				gameOver();
				return true;
			}
			else if (gameObject1Name.equals("Player") && gameObject2Name.equals("Hammer")) {
				if (!((Hammer)gameObject2).getInUse()) {
					((Player)gameObject1).setHammer((Hammer)gameObject2);
					((Hammer)gameObject2).setInUse(true);
				}
			}
			else if (gameObject2Name.equals("Player") && gameObject1Name.equals("Hammer")) {
				if (!((Hammer)gameObject1).getInUse()) {
					((Player)gameObject2).setHammer((Hammer)gameObject1);
					((Hammer)gameObject1).setInUse(true);
				}
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
				return true;
			}
		}
		return false;
	}

	/**
     * This method is called when the player loses the game
     */
	public void gameOver() {
		System.out.println("Game over, final score: " + score);
	}
	
	/**
     * This method is called when the player wins the game
     */
	public void gameWin() {
		System.out.println("Game win! final score: " + score);
	}
}
