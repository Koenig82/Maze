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

    public void move() throws InvalidMazeException{
        if(maze.isMovable(getCurrentPosition().getPosToNorth())) {

            if(!visited.containsKey(getCurrentPosition().
               getPosToNorth().hashCode())) {

                visited.put(getCurrentPosition().hashCode(),
                            getCurrentPosition());
                backTrack.push(getCurrentPosition());
                setCurrentPosition(getCurrentPosition().getPosToNorth());

                return;
            }
        } else if(maze.isMovable(getCurrentPosition().getPosToEast())) {

            if(!visited.containsKey(getCurrentPosition().
               getPosToEast().hashCode())) {

                visited.put(getCurrentPosition().hashCode(),
                            getCurrentPosition());
                backTrack.push(getCurrentPosition());
                setCurrentPosition(getCurrentPosition().getPosToEast());

                return;
            }
        } else if(maze.isMovable(getCurrentPosition().getPosToSouth())) {

            if(!visited.containsKey(getCurrentPosition().
               getPosToSouth().hashCode())) {

                visited.put(getCurrentPosition().hashCode(),
                            getCurrentPosition());
                backTrack.push(getCurrentPosition());
                setCurrentPosition(getCurrentPosition().getPosToSouth());

                return;
            }
        } else if(maze.isMovable(getCurrentPosition().getPosToWest())) {

            if(!visited.containsKey(getCurrentPosition().
               getPosToWest().hashCode())) {

                visited.put(getCurrentPosition().hashCode(),
                            getCurrentPosition());
                backTrack.push(getCurrentPosition());
                setCurrentPosition(getCurrentPosition().getPosToWest());

                return;
            }
        } else {

            throw new InvalidMazeException("Robot trapped");
        }

        setCurrentPosition(backTrack.peek());
        backTrack.pop();
    }
}
