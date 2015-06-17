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
import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.*;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner
{
    public static void main(String[] args)
    {
    	//PO: create a world that has various bugs and set various behaviours
        ActorWorld world = new ActorWorld();
        //PO: this bug will take on the default constructor behaviour set as OneStep
        world.add(new Bug());
        
        Bug mybug = new Bug();
        //PO: set the behaviour to Circle
        mybug.setActorBehaviour(new Circle());
        mybug.setColor(Color.darkGray);
        
        Bug turnBug = new Bug();
        //PO: set the behaviour to Turn5
        turnBug.setActorBehaviour(new Turn5());
        turnBug.setColor(Color.yellow);
        
        Bug crazyBug =  new Bug();
        crazyBug.setColor(Color.PINK);
        //PO: set the behaviour to Jump2
        crazyBug.setActorBehaviour(new Jump2());
        
        world.add(turnBug);
        world.add(mybug);
        world.add(crazyBug);
        world.add(new Rock());
        world.show();
    }
}
