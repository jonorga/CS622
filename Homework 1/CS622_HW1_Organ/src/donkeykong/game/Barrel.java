/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: Barrel.java
 * Description: This file contains the Barrel class. This class extends the EnemyObject class and includes
 * a variable for barrelType (blue or red).
 */

package donkeykong.game;

public class Barrel extends EnemyObject {
	private String barrelType;
	
	/**
     * This is the constructor method that sets the position and game area variables through super.
     * It also initializes the barrelType variable to the passed in value.
     */
	public Barrel(int xPosition, int yPosition, GameArea gameArea, String barrelType) {
		super(xPosition, yPosition, gameArea);
		this.barrelType = barrelType;
	}
	
	/**
     * This method defines any action that should be taken continuously, in this case, the barrel falls
     * after being placed.
     */
	public void update() {
		gameArea.moveGameObject(this, xPosition, yPosition - 1);
	}

	/**
     * This method overrides the toString method from the EnemyObject class to also return Barrel and the
     * barrelType
     * @return String
     */
	public String toString() {
		return super.toString() + "_Barrel" + barrelType;
	}
}
