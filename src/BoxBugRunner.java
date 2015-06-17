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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */
/*
 * Patricia Organ 01110489 - Assignment Lab 5 - CT548 - Object Oriented Design and Development
 */
import info.gridworld.actor.ActorWorld;
//PO: added two more imports to combine the executables to show all uses of new code
import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BoxBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        BoxBug alice = new BoxBug(6);
        alice.setColor(Color.ORANGE);
        BoxBug bob = new BoxBug(3);
         //PO: change the behaviour of one of the BoxBugs
        bob.setActorBehaviour(new Turn5());
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        
        //PO: add 3 regular Bugs to this program also
        Bug bugbug =  new Bug();
        bugbug.setColor(Color.CYAN);
        world.add(bugbug);
        //PO: change the behaviour of the bugbug to Circle
        bugbug.setActorBehaviour(new Circle());
        
        //PO: this bug buggsy has the default behaviour
        Bug buggsy =  new Bug();
        buggsy.setColor(Color.green);
        world.add(buggsy);
        
        Bug crazyBug =  new Bug();
        crazyBug.setColor(Color.PINK);
        world.add(crazyBug);
        //PO: set the behaviour to Jump2
        crazyBug.setActorBehaviour(new Jump2());

        //PO: add a rock to this world in a rondom place
        world.add(new Rock());
        world.show();
    }
}