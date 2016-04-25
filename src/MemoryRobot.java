/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 */
import java.util.HashMap;
import java.util.Stack;

/**
 * This class is an implementation of the abstract Robot class
 * This Robot uses a stack memory to handle backtracking and a hashtable to
 * keep track of positions visited
 *
 * It checks for new paths starting north and then clockwise order.
 */
public class MemoryRobot extends Robot {

    private HashMap<Integer, Position> visited;
    private Stack<Position> backTrack;

    /**
     * Constructor for Memoryrobot
     * @param maze a Maze object
     */
    public MemoryRobot(Maze maze) {
        super(maze);
        visited = new HashMap<>();
        backTrack = new Stack<>();
    }

    /**
     * A method to move the robot
     */
    public void move() {

        //Check the different directions clockwise and move if valid
        if(doMove(getCurrentPosition().getPosToNorth())) {
            //end the method if a move was made
            return;

        } else if(doMove(getCurrentPosition().getPosToEast())) {

            return;

        } else if(doMove(getCurrentPosition().getPosToSouth())) {

            return;

        } else if(doMove(getCurrentPosition().getPosToWest())) {

            return;

        }
        //if no moves can be done the maze is invalid
        if(backTrack.isEmpty()) {
            System.out.println("Maze must have path from start to finish");
            System.exit(-1);
        }
        //backtrack until a move can be made
        backTrack.pop();
        setCurrentPosition(backTrack.peek());
    }

    /**
     * This method is used by move-method to execute the check and move
     * @param pos the position to check and move to if valid
     * @return boolean (true if a move was made)
     */
    private boolean doMove(Position pos){
        if(maze.isMovable(pos)) {
            //check the hashtable if the position is visited
            if(!visited.containsKey(pos.hashCode())) {
                //add the position to visited-table and backtrack-stack
                visited.put(pos.hashCode(), pos);
                backTrack.push(pos);
                //update position and return
                setCurrentPosition(pos);

                return true;
            }
        }
        return false;
    }
}
