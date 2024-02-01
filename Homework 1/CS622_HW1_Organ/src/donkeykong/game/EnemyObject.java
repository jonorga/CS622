/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: EnemyObject.java
 * Description: This file contains the EnemyObject class. This class extends the GameObject class and defines a template for the
 * enemy objects. This leaves open the possibility of specifying qualities specific to enemy objects if needed.
 */

package donkeykong.game;

public abstract class EnemyObject extends GameObject {
	/**
     * This is the constructor method that sets the position and game area variables through super.
     */
	public EnemyObject(int xPosition, int yPosition, GameArea gameArea) {
		super(xPosition, yPosition, gameArea);
	}
	
	/**
     * This method overrides the toString method from the GameObject class to return "Player"
     * @return String
     */
	@Override
	public String toString() {
		return "EnemyObject";
	}
}
