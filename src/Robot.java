/**
 * Created by konig on 2016-04-23.
 */
public abstract class Robot {

    private Position position;
    protected Maze maze;

    public Robot(Maze maze) {
        position = maze.getStartPosition();
        this.maze = maze;
    }

    public abstract void move();

    public Position getCurrentPosition() {
        return position;
    }

    protected void setCurrentPosition(Position pos) {
        position = pos;
    }

    public boolean hasReachedGoal() {
        return maze.isGoal(position);
    }
}
