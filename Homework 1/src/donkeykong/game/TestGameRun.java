package donkeykong.game;

public class TestGameRun {

	public static void main(String[] args) {
		System.out.println("Test Game Run Started...");
		GameManager gameManager = new GameManager();
		
		// Player movement example
		//gameManager.movePlayer(1);
		//gameManager.movePlayer(2);
		//gameManager.movePlayer(3);
		//gameManager.movePlayer(0);
		
		
		// Enemy throws barrel example
		//gameManager.enemyThrowBarrel();
		//gameManager.enemyThrowBarrel();
		//gameManager.enemyThrowBarrel();
		
		
		// Player can lose example
		//gameManager.enemyThrowBarrel();
		//for (int i = 0; i < 9; i++)
		//	gameManager.updateGameArea();
		
		
		// Player can get hammer and destroy barrels example
		gameManager.movePlayer(0);
		for (int i = 0; i < 5; i++)
			gameManager.movePlayer(1);
		gameManager.enemyThrowBarrel();
		for (int i = 0; i < 4; i++)
			gameManager.updateGameArea();
		
		
		// Player can win the game example
		gameManager.movePlayer(2);
		gameManager.movePlayer(2);
		for (int i = 0; i < 4; i++)
			gameManager.movePlayer(1);
		System.out.println("\nTest Game Run Complete...");
	}

}
