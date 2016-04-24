/**
 * Created by konig on 2016-04-24.
 */
public class RightHandRuleRobot extends Robot{

    private int directionMoved;//0=w 1=s 2=e 3=n

    public RightHandRuleRobot(Maze maze) {
        super.(maze);
        directionMoved = 1;
    }

    public void move() {
        if(directionMoved == 1) {

            if(maze.isMovable(getCurrentPosition().getPosToWest())) {

                setCurrentPosition(getCurrentPosition().getPosToWest());
                directionMoved = 0;

                return;

            } else if(maze.isMovable(getCurrentPosition().getPosToSouth())) {

                setCurrentPosition(getCurrentPosition().getPosToSouth());
                directionMoved = 1;

                return;

            } else if(maze.isMovable(getCurrentPosition().getPosToEast())) {

                setCurrentPosition(getCurrentPosition().getPosToEast());
                directionMoved = 2;

                return;

            } else if(maze.isMovable(getCurrentPosition().getPosToNorth())) {

                setCurrentPosition(getCurrentPosition().getPosToNorth());
                directionMoved = 3;

                return;
            }
        }

        if(directionMoved == 0) {

            if(maze.isMovable(getCurrentPosition().getPosToWest())) {

                setCurrentPosition(getCurrentPosition().getPosToWest());
                directionMoved = 'west';

                return;
            }
        }
    }

    private void chooseNextMovable() {
        directionMoved = (directionMoved + 1) % 4;
    }
}
