/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 *
 * This class handles the feedback for invalid maze-textfiles
 */
public class InvalidMazeException extends Exception {

    /**
     * Call this exeption with a message to be printed
     * @param message The message to be printed
     */
    public InvalidMazeException(String message) {
        super(message);
    }
}
