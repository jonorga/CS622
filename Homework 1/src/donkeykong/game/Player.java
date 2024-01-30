/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: Player.java
 * Description: This file contains the Player class. This class extends the GameObject class and defines the player.
 * It contains methods to handle the player hammer and check if they have one.  
 */

package donkeykong.game;

public class Player extends GameObject {
	private Hammer hammer;
	
	/**
     * This is the constructor method that sets the position and game area variables through super
     */
	public Player(int xPosition, int yPosition, GameArea gameArea) {
		super(xPosition, yPosition, gameArea);
	}
	
	/**
     * This method sets the hammer to the player and moves it accordingly
     */
	public void setHammer(Hammer hammer) {
		System.out.println("Player acquired hammer!");
		this.hammer = hammer;
		gameArea.moveGameObject(hammer, xPosition + 1, yPosition);
	}
	
	/**
     * This method moves the hammer to stay with the player while they have it.
     */
	public void updateHammer() {
		gameArea.moveGameObject(hammer, xPosition + 1, yPosition);
	}
	
	/**
     * This method checks whether the player has a hammer
     * @return boolean
     */
	public boolean hasHammer() {
		return hammer != null;
	}
	
	/**
     * This method would handle anything the GameObject is supposed to do continuously, 
     * which doesn't apply to this class, so it's left empty. 
     */
	@Override
	public void update() {}
	
	/**
     * This method overrides the toString method from the GameObject class to return "Player"
     * @return String
     */
	@Override
	public String toString() {
		return "Player";
	}
}
