/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 */
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * A class to create a maze from a textfile
 *
 * The mazewalls are represented by '*'
 * An open space in the maze is represented by ' '
 * Start and Goal is represented by 'S' and 'G'
 */
public class Maze {

    private char[][] mazeData;
    private Position start;

    /**
     * Constructor for mazeclass
     * @param reader A java IOreader connected to a textfile containing the maze
     * @throws InvalidMazeException
     */
    public Maze(Reader reader) throws InvalidMazeException {
        ArrayList<String> rows = new ArrayList<>();

        try{
            //counters to prevent invalid number of starts and goals
            int numStart = 0, numGoal = 0;
            //variable to hold the reader input
            int readChar;
            //the string to contain each line in the text
            String temp = "";

            //while reading is being done, check for S, G and \n
            while((readChar = reader.read()) != -1) {
                if(readChar == 'S') {

                    numStart++;
                    start = new Position(rows.size(), temp.length());
                }
                if(readChar == 'G') {

                    numGoal++;
                }
                if(readChar == '\n') {
                    //at \n, add the string to the arraylist and reset it
                    rows.add(temp);
                    temp = "";
                } else {
                    //add character to string
                    temp = temp + (char) readChar;
                }
            }
            //making sure the last line is added (may not contain \n
            if(temp.length() > 0) {

                rows.add(temp);
            }
            //making sure the correct number of start and goal exists
            if(numStart != 1 || numGoal != 1) {

                throw new InvalidMazeException("Invalid maze. Must contain" +
                                               " 1 start and 1 goal");
            }
            //fill the 2d array with the characters read from textfile
            mazeData = new char[rows.size()][];
                for(int i = 0; i < rows.size(); i++) {
                mazeData[i] = rows.get(i).toCharArray();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method to check if the next position is valid
     * @param pos the position to check
     * @return boolean
     */
    public boolean isMovable(Position pos) {

        if(isWithinMazeBounds(pos) && (
         mazeData[pos.getX()][pos.getY()] == ' ' ||
         mazeData[pos.getX()][pos.getY()] == 'S' ||
         mazeData[pos.getX()][pos.getY()] == 'G')) {
             return true;
        }
        return false;
    }

    /**
     * A method to check if the goal is reached
     * @param pos the position to check
     * @return boolean
     */
    public boolean isGoal(Position pos) {
        if(!isWithinMazeBounds(pos) ||
           mazeData[pos.getX()][pos.getY()] != 'G') {

            return false;
        }
        return true;
    }

    /**
     * A method to get the maze startposition
     * @return startposition
     */
    public Position getStartPosition() {
        return start;
    }

    /**
     * A method to check if a position is within the maze boundries
     * @param pos the position to check
     * @return boolean
     */
    private boolean isWithinMazeBounds(Position pos) {
        if(pos.getX() < 0 ||
           pos.getX() >= mazeData.length ||
           pos.getY() < 0 ||
           pos.getY() >= mazeData[pos.getX()].length) {

            return false;
        }
        return true;
    }
}
