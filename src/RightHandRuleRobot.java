/**
 * Created by konig on 2016-04-24.
 */
public class RightHandRuleRobot extends Robot{

    private int direction;//0=w 1=s 2=e 3=n

    public RightHandRuleRobot(Maze maze) {
        super(maze);
        direction = 1;
    }

    public void move() {

        if(direction == 1) {

            if (maze.isMovable(getCurrentPosition().getPosToWest())) {

                setCurrentPosition(getCurrentPosition().getPosToWest());
                direction = 0;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToSouth())) {

                setCurrentPosition(getCurrentPosition().getPosToSouth());
                direction = 1;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToEast())) {

                setCurrentPosition(getCurrentPosition().getPosToEast());
                direction = 2;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToNorth())) {

                setCurrentPosition(getCurrentPosition().getPosToNorth());
                direction = 3;

                return;

            } else {

                System.out.println("trapped");
            }

        }
        if(direction == 0) {

            if(maze.isMovable(getCurrentPosition().getPosToNorth())) {

                setCurrentPosition(getCurrentPosition().getPosToNorth());
                direction = 3;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToWest())) {

                setCurrentPosition(getCurrentPosition().getPosToWest());
                direction = 0;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToSouth())) {

                setCurrentPosition(getCurrentPosition().getPosToSouth());
                direction = 1;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToEast())) {

                setCurrentPosition(getCurrentPosition().getPosToEast());
                direction = 2;

                return;

            } else {

                System.out.println("trapped");
            }
        }

        if(direction == 2) {

            if (maze.isMovable(getCurrentPosition().getPosToSouth())) {

                setCurrentPosition(getCurrentPosition().getPosToSouth());
                direction = 1;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToEast())) {

                setCurrentPosition(getCurrentPosition().getPosToEast());
                direction = 2;

                return;

            } else if(maze.isMovable(getCurrentPosition().getPosToNorth())) {

                setCurrentPosition(getCurrentPosition().getPosToNorth());
                direction = 3;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToWest())) {

                setCurrentPosition(getCurrentPosition().getPosToWest());
                direction = 0;

                return;

            } else {

                System.out.println("trapped");
            }
        }

        if(direction == 3) {

            if (maze.isMovable(getCurrentPosition().getPosToEast())) {

                setCurrentPosition(getCurrentPosition().getPosToEast());
                direction = 2;

                return;

            } else if(maze.isMovable(getCurrentPosition().getPosToNorth())) {

                setCurrentPosition(getCurrentPosition().getPosToNorth());
                direction = 3;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToWest())) {

                setCurrentPosition(getCurrentPosition().getPosToWest());
                direction = 0;

                return;

            } else if (maze.isMovable(getCurrentPosition().getPosToSouth())) {

                setCurrentPosition(getCurrentPosition().getPosToSouth());
                direction = 1;

                return;

            } else {

                System.out.println("trapped");
            }
        }
    }
}
