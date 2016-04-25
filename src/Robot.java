/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 *
 * This abstract class is a blueprint for different implementations of robots
 */
public abstract class Robot {

    private Position position;
    protected Maze maze;

    /**
     * Constructor method for robot
     * @param maze
     */
    public Robot(Maze maze) {
        position = maze.getStartPosition();
        this.maze = maze;
    }

    /**
     * Other Robots must implement move
     */
    public abstract void move();

    /**
     * Gets the robots current position in the maze
     * @return position
     */
    public Position getCurrentPosition() {
        return position;
    }

    /**
     * Sets the robots current position in the maze
     * @param  pos The position to set
     */
    protected void setCurrentPosition(Position pos) {
        position = pos;
    }

    /**
     * Checks if the robot is at the goal
     * @return boolean
     */
    public boolean hasReachedGoal() {
        return maze.isGoal(position);
    }
}
