/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 */

/**
 * This class is an implementation of the abstract Robot-class
 * This robot always searches for the next movable position to its right
 * A direction variable exists to represent the direction the robot is facing
 */
public class RightHandRuleRobot extends Robot{

    //0 = West, 1 = South, 2 = East, 3 = North
    private int direction;

    /**
     * The constructor for RightHandRuleRobot
     * @param maze a Maze object
     */
    public RightHandRuleRobot(Maze maze) {
        super(maze);
        //the robot will start facing south
        direction = 1;
    }

    /**
     * A method to move the robot
     */
    public void move() {
        //if the robots direction is south
        if(direction == 1) {
            //start looking for paths on the right
            if (maze.isMovable(getCurrentPosition().getPosToWest())) {

                setCurrentPosition(getCurrentPosition().getPosToWest());
                direction = 0;

                return;
            //then forward and counter-clockwise
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
                //The maze is invalid if the robot is trapped
                System.out.println("Maze must have path from start to finish");
                System.exit(-1);
            }

        }
        //west
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

                System.out.println("Maze must have path from start to finish");
                System.exit(-1);
            }
        }
        //east
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

                System.out.println("Maze must have path from start to finish");
                System.exit(-1);
            }
        }
        //north
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

                System.out.println("Maze must have path from start to finish");
                System.exit(-1);
            }
        }
    }
}
