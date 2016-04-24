import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Maze {

    private char[][] mazeData;
    private Position start;

    public Maze(Reader reader) throws InvalidMazeException {
        ArrayList<String> rows = new ArrayList<>();

        try{
            int numStart = 0, numGoal = 0;
            int c;
            String temp = "";

            while((c = reader.read()) != -1) {
                if(c == 'S') {

                    numStart++;
                }
                if(c == 'G') {

                    numGoal++;
                    start = new Position(temp.length(), rows.size());
                }
                if(c == '\n') {

                    rows.add(temp);
                    temp = "";
                } else {

                    temp = temp + (char) c;
                }
            }

            if(temp.length() > 0) {

                rows.add(temp);
            }

            if(numStart != 1 || numGoal != 1) {

                throw new InvalidMazeException("Invalid maze");
            }

            mazeData = new char[rows.size()][];

            for(int i = 0; i < rows.size(); i++) {
                mazeData[i] = rows.get(i).toCharArray();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isMovable(Position pos) {

        if(!isWithinMazeBounds(pos) ||
           mazeData[pos.getY()][pos.getX()] != ' ' ||
           mazeData[pos.getY()][pos.getX()] != 'S' ||
           mazeData[pos.getY()][pos.getX()] != 'G') {
            return false;
        }
        return true;
    }

    public boolean isGoal(Position pos) {
        if(!isWithinMazeBounds(pos) ||
           mazeData[pos.getY()][pos.getX()] != 'G') {

            return false;
        }
        return true;
    }

    public Position getStartPosition() {
        return start;
    }

    private boolean isWithinMazeBounds(Position pos) {
        if(pos.getY() < 0 ||
           pos.getY() >= mazeData.length ||
           pos.getX() < 0 ||
           pos.getX() >= mazeData[pos.getY()].length) {

            return false;
        }
        return true;
    }
}
