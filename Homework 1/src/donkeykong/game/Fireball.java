/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: Fireball.java
 * Description: This file contains the Fireball class. This class extends the EnemyObject class and is left as a
 * placeholder to further define the specificities of fireballs in Donkey Kong.
 */

package donkeykong.game;

public class Fireball extends EnemyObject {
	/**
     * This is the constructor method that sets the position and game area variables through super.
     */
	public Fireball(int xPosition, int yPosition, GameArea gameArea) {
		super(xPosition, yPosition, gameArea);
	}
	
	/**
     * This is the required update method to be called for any needed continuous actions.
     */
	public void update() {
		
	}

	/**
     * This method overrides the toString method from the EnemyObject class to also return Fireball
     * @return String
     */
	public String toString() {
		return super.toString() + "_Fireball";
	}
}
