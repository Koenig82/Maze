/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 */

/**
 * The Position-class
 *
 * Methods exist to acces all current and adjecent positions.
 * There is also a hashfunktion to give positions different hashkeys
 */
public class Position {

    private int x;
    private int y;

    /**
     * The cunstructor for Position
     * @param xPos the first coordinate of the position
     * @param yPos the second
     */
    public Position(int xPos, int yPos) {
        x = xPos;
        y = yPos;
    }

    /**
     * A method to get the x value from position
     * @return x integer value
     */
    public int getX() {
        return x;
    }

    /**
     * A method to get the y value from position
     * @return y integer value
     */
    public int getY() {
        return y;
    }

    /**
     * A method to get the position adjecent to the south of current position
     * @return Position south
     */
    public Position getPosToSouth() {
        return new Position(x + 1, y);
    }

    /**
     * A method to get the position adjecent to the north of current position
     * @return Position north
     */
    public Position getPosToNorth() {
        return new Position(x - 1, y);
    }

    /**
     * A method to get the position adjecent to the west of current position
     * @return Position west
     */
    public Position getPosToWest() {
        return new Position(x, y - 1);
    }

    /**
     * A method to get the position adjecent to the east of current position
     * @return Position east
     */
    public Position getPosToEast() {
        return new Position(x, y + 1);
    }

    /**
     * A method to compare two positions
     * @param o The Position-object to be compared to this position
     * @return boolean (true if they are equal)
     */
    public boolean equals(Object o) {
        if(o instanceof Position) {

           Position pos = (Position)o;

            if(pos.x == x && pos.y == y) {

                return true;
            }
        }
        return false;
    }

    /**
     * hashfunction to generate integers to represent any given position
     * @return integer
     */
    public int hashCode() {
        return (x + " " + y).hashCode();
    }
}
