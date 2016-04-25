public class Position {

    private int x;
    private int y;

    public Position(int xPos, int yPos) {
        x = xPos;
        y = yPos;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getPosToSouth() {
        return new Position(x + 1, y);
    }

    public Position getPosToNorth() {
        return new Position(x - 1, y);
    }

    public Position getPosToWest() {
        return new Position(x, y - 1);
    }

    public Position getPosToEast() {
        return new Position(x, y + 1);
    }

    public boolean equals(Object o) {
        if(o instanceof Position) {

           Position pos = (Position)o;

            if(pos.x == x && pos.y == y) {

                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (x + " " + y).hashCode();
    }
}
