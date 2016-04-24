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
        visited = new HashMap<Integer, Position>();
        backTrack = new Stack<Position>();
    }

    public void move() {
        if(maze.isMovable(getCurrentPosition().getPosToNorth())) {

            if(!visited.containsKey(getCurrentPosition().
               getPosToNorth().hashCode())) {

                visited.put(getCurrentPosition().hashCode())
                backTrack.push(getCurrentPosition());
                setCurrentPosition(getCurrentPosition().getPosToNorth());

                return;
            }
        }

        if(maze.isMovable(getCurrentPosition().getPosToEast())) {

            if(!visited.containsKey(getCurrentPosition().
               getPosToEast().hashCode())) {

                visited.put(getCurrentPosition().hashCode())
                backTrack.push(getCurrentPosition());
                setCurrentPosition(getCurrentPosition().getPosToEast());

                return;
            }
        }

        if(maze.isMovable(getCurrentPosition().getPosToSouth())) {

            if(!visited.containsKey(getCurrentPosition().
               getPosToSouth().hashCode())) {

                visited.put(getCurrentPosition().hashCode())
                backTrack.push(getCurrentPosition());
                setCurrentPosition(getCurrentPosition().getPosToSouth());

                return;
            }
        }

        if(maze.isMovable(getCurrentPosition().getPosToWest())) {

            if(!visited.containsKey(getCurrentPosition().
               getPosToWest().hashCode())) {

                visited.put(getCurrentPosition().hashCode())
                backTrack.push(getCurrentPosition());
                setCurrentPosition(getCurrentPosition().getPosToWest());

                return;
            }
        }

        setCurrentPosition(backTrack.peek());
        backTrack.pop();
    }
}
