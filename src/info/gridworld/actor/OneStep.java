/*
 * Patricia Organ 01110489 - Assignment Lab 5 - CT548 - Object Oriented Design and Development
 */


package info.gridworld.actor;
//import the required classes for this code
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
/*PO:
 * this class implements the Actorbehaviour interface and its methods
 */
public class OneStep implements Actorbehaviour {
	
	/**PO:
     * Moves this actor to a new location. If there is another actor at the
     * given location, it is removed. <br />
     * Precondition: (1) This actor is contained in a grid (2)
     * <code>newLocation</code> is valid in the grid of this actor
     * @param newLocation the new location
     * @param the actor that called the method
     */
	 public void moveTo(Actor actor, Location newLocation)
	    {
		 	//creating the variables to make the code easier to read
		 	Grid<Actor> grid = actor.getGrid();
		 	Location location = actor.getLocation();
		 
	        if (grid == null)
	            throw new IllegalStateException("This actor is not in a grid.");
	        if (grid.get(location) != actor)
	            throw new IllegalStateException(
	                    "The grid contains a different actor at location "
	                            + location + ".");
	        if (!grid.isValid(newLocation))
	            throw new IllegalArgumentException("Location " + newLocation
	                    + " is not valid.");

	        if (newLocation.equals(location))
	            return;
	        
	        //this line below was added
	        actor.removeSelfFromGrid();
	        //changed the code slightly to make sure now that not being called from within the actor that we refer to the
	        //actor itself when removing and placing actor on grid
	        //grid.remove(location);
	        Actor other = grid.get(newLocation);
	        if (other != null)
	            other.removeSelfFromGrid();
	        location = newLocation;
	        actor.putSelfInGrid(grid, location);
	        //grid.put(location, actor);
	    }
	 
	    /**
	     * Tests whether this bug can move forward into a location that is empty or
	     * contains a flower.
	     * @return true if this bug can move.
	     */
	    public boolean canMove(Actor actor)
	    {
	    	//PO: updated the methods after the move from  the Bug Class to be called from
	    	//PO: the passed actor
	        Grid<Actor> gr = actor.getGrid();
	        if (gr == null)
	            return false;
	        Location loc = actor.getLocation();
	        Location next = loc.getAdjacentLocation(actor.getDirection());
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return (neighbor == null) || (neighbor instanceof Flower);
	        // ok to move into empty location or onto flower
	        // not ok to move onto any other actor
	         
	    }	

	    /**
	     * Moves the bug forward, putting a flower into the location it previously
	     * occupied.
	     */
		  public void move(Actor actor)
		    {
			  	//PO: updated the methods after the move from  the Bug Class to be called from
		    	//PO: the passed actor
		        Grid<Actor> gr = actor.getGrid();
		        if (gr == null)
		            return;
		        Location loc = actor.getLocation();
		        Location next = loc.getAdjacentLocation(actor.getDirection());
		        if (gr.isValid(next))
		        	//PO: alter the original code instead of calling the 
		        	//PO: moveTo method in Actor call the method that is from this current behaviour
		            this.moveTo(actor, next);
		        else
		            actor.removeSelfFromGrid();
		        Flower flower = new Flower(actor.getColor());
		        flower.putSelfInGrid(gr, loc);
		        
		    }
	

}
