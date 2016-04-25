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
            int readChar;
            String temp = "";

            while((readChar = reader.read()) != -1) {
                if(readChar == 'S') {

                    numStart++;
                    start = new Position(rows.size(), temp.length());
                }
                if(readChar == 'G') {

                    numGoal++;
                }
                if(readChar == '\n') {

                    rows.add(temp);
                    temp = "";
                } else {

                    temp = temp + (char) readChar;
                }
            }

            if(temp.length() > 0) {

                rows.add(temp);
            }

            if(numStart != 1 || numGoal != 1) {

                throw new InvalidMazeException("Invalid maze. Must contain" +
                                               " 1 start and 1 goal");
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

        if(isWithinMazeBounds(pos) && (
         mazeData[pos.getX()][pos.getY()] == ' ' ||
         mazeData[pos.getX()][pos.getY()] == 'S' ||
         mazeData[pos.getX()][pos.getY()] == 'G')) {
             return true;
        }
        return false;
    }

    public boolean isGoal(Position pos) {
        if(!isWithinMazeBounds(pos) ||
           mazeData[pos.getX()][pos.getY()] != 'G') {

            return false;
        }
        return true;
    }

    public Position getStartPosition() {
        return start;
    }

    private boolean isWithinMazeBounds(Position pos) {
        if(pos.getY() < 0 ||
           pos.getY() >= mazeData[pos.getX()].length ||
           pos.getX() < 0 ||
           pos.getX() >= mazeData.length) {

            return false;
        }
        return true;
    }
}
