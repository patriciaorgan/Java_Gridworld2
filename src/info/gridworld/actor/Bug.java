/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

/*
 * Patricia Organ 01110489 - Assignment Lab 5 - CT548 - Object Oriented Design and Development
 */

package info.gridworld.actor;
//PO: removing this import as no longer required
//import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Bug extends Actor
{
    /**
     * Constructs a red bug.
     */
    public Bug()
    {
        setColor(Color.RED);
        //PO: set the actorbehaviour when initialised to the basic forward one step
        //PO: but can be altered in runtime
        this.setActorBehaviour(new OneStep());
    }

    /**
     * Constructs a bug of a given color.
     * @param bugColor the color for this bug
     */
    public Bug(Color bugColor)
    {
        setColor(bugColor);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }
    
    //PO: the below version of code worked when the behaviours just altered the turns 
    //PO: ok when just had OneStep, Turn5 and Circle Behaviour classes
	//PO: but as progressed to wanting more elaborate behaviours like move 2 steps in one go, Jump2
	//PO: needed to rework the code and move the method from Bug into Behaviour classes
    //PO: moved 2 methods move() and canMove()
    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    /* public void move()
    {
    	this.getActbehave().move(this);
    	
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
        	//PO: alter the original code instead of calling the 
        	//PO: moveTo method in Actor call the method that is from its current behaviour
            this.getActbehave().moveTo(this);
       // else
            //removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
        
    }*/

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    /*
    public boolean canMove()
    {
    	return this.getActbehave().canMove(this);
    	
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
         * *
         
    }
    */
}
