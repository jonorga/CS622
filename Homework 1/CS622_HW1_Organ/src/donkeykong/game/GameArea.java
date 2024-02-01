/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: GameArea.java
 * Description: This file contains the GameArea class. This class manages the game area and the objects in it.
 * This includes placing, moving, and destroying game objects. The class can also call the update method on 
 * every object in the game area.  
 */

package donkeykong.game;

public class GameArea {
	private GameObject[][] board = new GameObject[10][10];
	private GameManager gameManager;
	
	/**
     * This is the constructor method ties the game area to a game manager object. I set the constructor
     * up this way intentionally so the game area has exactly one game manager.
     */
	public GameArea(GameManager gameManager) {
		this.gameManager = gameManager;
	}
	
	/**
     * This is the public method for moving a game object that can be called by any object. This
     * method is an intermediary step that checks for collisions and how they should be handled
     */
	public void moveGameObject(GameObject gameObject, int xPosition, int yPosition) {
		if (board[yPosition][xPosition] != null) {
			if (!gameManager.collision(gameObject, board[yPosition][xPosition])) {
				board[gameObject.yPosition][gameObject.xPosition] = null;
				gameObject.setCoordinates(xPosition, yPosition);
				moveGameObject(gameObject);
			}
			else {
				System.out.println("Collision between " + gameObject.toString() + " and " + 
						board[yPosition][xPosition].toString());
			}
		}
		else {
			board[gameObject.yPosition][gameObject.xPosition] = null;
			gameObject.setCoordinates(xPosition, yPosition);
			moveGameObject(gameObject);
		}
	}
	
	/**
     * This overloaded private method is how the objects are moved. It is set to private to ensure
     * the game area is the only one that can actually directly move objects.
     */
	private void moveGameObject(GameObject gameObject) {
		board[gameObject.yPosition][gameObject.xPosition] = gameObject;
		System.out.println(gameObject.toString() + " moved to " + gameObject.yPosition + ", " +
				gameObject.xPosition);
	}
	
	/**
     * This method places objects on the board when they're first instantiated. It also ensures objects
     * aren't being placed on top of each other. 
     */
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
	
	/**
     * This method destroys a game object from the board.
     */
	public void destroyGameObject(GameObject gameObject) {
		board[gameObject.yPosition][gameObject.xPosition] = null;
		System.out.println(gameObject + " destroyed");
	}
	
	/**
     * This method calls update on every game object on the board.
     */
	public void updateAll() {
		int xValue = 0;
		int yValue = 0;
		while (xValue < 10) {
			yValue = 0;
			while (yValue < 10) {
				if (board[xValue][yValue] != null) {
					board[xValue][yValue].update();
				}
				yValue++;
			}
			xValue++;
		}
	}
}
