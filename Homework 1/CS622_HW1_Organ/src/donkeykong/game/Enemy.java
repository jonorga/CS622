/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: Enemy.java
 * Description: This file contains the Enemy class. This class extends the GameObject class and defines the enemy.
 * It contains a method to throw barrels.  
 */

package donkeykong.game;

public class Enemy extends GameObject {
	private Barrel[] enemyBarrels = new Barrel[10];
	private int barrelCount;
	
	/**
     * This is the constructor method that sets the position and game area variables through super.
     * It also initializes the barrelCount variable.
     */
	public Enemy(int xPosition, int yPosition, GameArea gameArea) {
		super(xPosition, yPosition, gameArea);
		barrelCount = 0;
	}
	
	/**
     * This method "throws" a barrel by instantiating one next to the enemy, and increments the barrelCount
     * variable
     */
	public void throwBarrel(String barrelType) {
		enemyBarrels[barrelCount] = new Barrel(xPosition + 1, yPosition, gameArea, barrelType);
		gameArea.placeGameObject(enemyBarrels[barrelCount]);
		barrelCount++;
	}
	
	/**
     * This is the required update method, but the enemy doesn't move or necessarily do anything every update,
     * so this is intentionally left empty.
     */
	@Override
	public void update() {}
	
	/**
     * This method overrides the toString method from the GameObject class to return "Enemy"
     * @return String
     */
	@Override
	public String toString() {
		return "Enemy";
	}
}
