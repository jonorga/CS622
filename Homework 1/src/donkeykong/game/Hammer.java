/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: Hammer.java
 * Description: This file contains the Hammer class. This class extends the GameObject class and defines the Hammer
 * that the player uses if they pick it up. It also contains methods to check if it's in use currently.
 */

package donkeykong.game;

public class Hammer extends GameObject {
	private boolean inUse;
	private int lifeSpan;
	
	/**
     * This is the constructor method that sets the position and game area variables through super. It
     * also initializes the inUse and lifeSpan variables
     */
	public Hammer(int xPosition, int yPosition, GameArea gameArea) {
		super(xPosition, yPosition, gameArea);
		inUse = false;
		lifeSpan = 20;
	}
	
	/**
     * This is the required update method. In the case of the Hammer, this method keeps track of the hammer's life span
     * and destroys it once it has completed it. 
     */
	public void update() {
		if (inUse) {
			if (lifeSpan > 0) {
				lifeSpan--;
			}
			else {
				gameArea.destroyGameObject(this);
			}
		}
	}
	
	/**
     * This is the getter method for the inUse variable
     * @return boolean
     */
	public boolean getInUse() {
		return inUse;
	}
	
	/**
     * This is the setter method for the inUse variable
     */
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
	/**
     * This method overrides the toString method from the GameObject class to return "Hammer"
     * @return String
     */
	public String toString() {
		return "Hammer";
	}
}
