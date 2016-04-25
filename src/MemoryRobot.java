/**
 * Created by konig on 2016-04-24.
 */
import java.util.HashMap;
import java.util.Stack;

public class MemoryRobot extends Robot {

    private HashMap<Integer, Position> visited;
    private Stack<Position> backTrack;

    public MemoryRobot(Maze maze) {
        super(maze);
        visited = new HashMap<>();
        backTrack = new Stack<>();
    }

    public void move() {


        if(doMove(getCurrentPosition().getPosToNorth())) {

            return;

        } else if(doMove(getCurrentPosition().getPosToEast())) {

            return;

        } else if(doMove(getCurrentPosition().getPosToSouth())) {

            return;

        } else if(doMove(getCurrentPosition().getPosToWest())) {

            return;

        }
        backTrack.pop();
        setCurrentPosition(backTrack.peek());
    }

    public boolean doMove(Position pos){
        if(maze.isMovable(pos)) {

            if(!visited.containsKey(pos.hashCode())) {

                visited.put(pos.hashCode(), pos);
                backTrack.push(pos);
                setCurrentPosition(pos);

                return true;
            }
        }
        return false;
    }
}
