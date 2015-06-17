package info.gridworld.actor;
/*
 * Patricia Organ 01110489 - Assignment Lab 5 - CT548 - Object Oriented Design and Development
 */
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
/*PO:
 * this class implements the Actorbehaviour interface and its methods
 */
public class Jump2 implements Actorbehaviour {

	/**PO:
     * Moves this actor to a new location, this case will be 2 spcaes.
     * If there is another actor at the
     * given location, it is removed. <br />
     * Precondition: (1) This actor is contained in a grid (2)
     * <code>newLocation</code> is valid in the grid of this actor
     * @param newLocation the new location
     * @param newLocation the new location
     */
	
	public void moveTo(Actor actor, Location newLocation)
    {		
		//PO: creating the variables to make the code easier to read
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
        
        //PO: this line below was added
        actor.removeSelfFromGrid();
        //PO: changed the code slightly to make sure now that not being called from within the actor that we refer to the
        //PO: actor itself when removing and placing actor on grid
        //grid.remove(location);
        Actor other = grid.get(newLocation);
        if (other != null)
            other.removeSelfFromGrid();
        location = newLocation;
        actor.putSelfInGrid(grid, location);
  
    }//end moveTo method
	

    /**
     * PO: Moves the bug forward two spaces, putting a flower into the location it previously
     * occupied.
     */
	  public void move(Actor actor)
	    {
	    	
	        Grid<Actor> gr = actor.getGrid();
	        if (gr == null)
	            return;
	        Location loc = actor.getLocation();
	        Location next = loc.getAdjacentLocation(actor.getDirection());
	        //PO: using the first next find hte adjacent location to that
	        Location newNext = next.getAdjacentLocation(actor.getDirection());
	        //PO: check if that location is valid now
	        if (gr.isValid(newNext))
	        	//PO: alter the original code instead of calling the 
	        	//PO: moveTo method in Actor call the method that now in this behaviour
	            this.moveTo(actor, newNext);
	        else
	            actor.removeSelfFromGrid();
	        //PO: this behaviour will only leave one flower in the original spot
	        Flower flower = new Flower(actor.getColor());
	        flower.putSelfInGrid(gr, loc);
	        
	    }
	   
	  /**PO:
	     * Tests whether this bug can move forward 2 spaces into a location that is empty or
	     * contains a flower.
	     * @return true if this bug can move.
	     */
	    public boolean canMove(Actor actor)
	    {
	        Grid<Actor> gr = actor.getGrid();
	        if (gr == null)
	            return false;
	        Location loc = actor.getLocation();
	        Location next = loc.getAdjacentLocation(actor.getDirection());
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        //PO: changed the code here to check to see if their is a neighbouring actor of any kind
	        if (!( (neighbor == null) || (neighbor instanceof Flower)|| (neighbor instanceof Rock))) 
	        	return false;
	        //PO: now need to validate the second adjacent step
	        Location newNext = next.getAdjacentLocation(actor.getDirection());
	        if (!gr.isValid(newNext))
	            return false;
	        
	        neighbor = gr.get(newNext);
	        //PO: return as normal but with boolean of the 2nd step instead of next
	        return (neighbor == null) || (neighbor instanceof Flower); 
	        // ok to move into empty location or onto flower
	        // not ok to move onto any other actor
	         
	    }
	
}
