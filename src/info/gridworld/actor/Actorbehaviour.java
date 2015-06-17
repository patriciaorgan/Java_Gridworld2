/*
 * Patricia Organ 01110489 - Assignment Lab 5 - CT548 - Object Oriented Design and Development
 */
package info.gridworld.actor;

import info.gridworld.grid.Location;

public interface Actorbehaviour {

	public void moveTo(Actor actor,Location newLocation);
	public void move(Actor actor);
	public boolean canMove(Actor actor);

}
