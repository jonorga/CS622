| CS-622       | Advanced Programming Techniques |
|--------------|---------------------------------|
| Name         | Jonathan Organ                  |
| Date         | 1/29/2024                       |
| Course       | Spring                          |
| Assignment # | 1                               |

# Assignment Overview
In this assignment the objective was to create a define objects and the structure for a 
Donkey Kong game. Specifically, we had to define classes, method names, and parameters used
for the game similar to the example in class.

# Required Components
- Inheritance
	* All classes that will be initialized into the game area are subclasses of the GameObject class.
	This gives them all a reference to the game area and their positions through inheritance.
- Overriding a method
	* The GameObject class has an abstract method called update that all of the child classes are 
	required to override. The update method contains any function that the object should do
	continuously so they are all overriden in their child classes.
- Overloading a method
	* In the GameArea class, the moveGameObject method is overloaded. The public moveGameObject method
	takes the object, and its desired position and check for collisions and how they should be handled.
	If there are no collisions blocking the movement, a private moveGameObject method that is called after
	the GameObject's coordinates are updated, that moves the object to that position. 