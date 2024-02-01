/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 1/29/2024
 * File Name: GameObject.java
 * Description: This file contains the abstract GameObject class. This class acts as the superclass for all GameObjects
 * and provides its position and a reference to the game area. It also overrides the toString method and provides an 
 * update method to be called on all objects 
 */

package donkeykong.game;

public abstract class GameObject {
	GameArea gameArea;
	int xPosition;
	int yPosition;
	
	/**
     * This is the constructor method that sets the position and game area variables
     */
	public GameObject(int xPosition, int yPosition, GameArea gameArea) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.gameArea = gameArea;
	}
	
	/**
     * This method allows for setting the coordinates of the game object 
     */
	public void setCoordinates(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	/**
     * This method is made abstract to force game objects to define what they're supposed to do
     * during an update
     */
	public abstract void update();
	
	/**
     * This method overrides the toString method from the object class to return "GameObject" instead
     * @return String
     */
	@Override
	public String toString() {
		return "GameObject";
	}
}
