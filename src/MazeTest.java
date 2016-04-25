/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 */

import org.junit.Test;
import java.io.FileReader;

/**
 * JUnit class to test the Maze Class
 */
public class MazeTest {

    @Test
    public void canCreateNewMaze() throws Exception {

        FileReader reader = new FileReader("test.txt");
        new Maze(reader);
    }

    @Test (expected = InvalidMazeException.class)
    public void shouldThrowExceptionIfNoStartPosition() throws Exception {

        FileReader reader = new FileReader("nostart.txt");
        new Maze(reader);

    }

    @Test (expected = InvalidMazeException.class)
    public void shouldThrowExceptionIfNoGoalPosition() throws Exception {

        FileReader reader = new FileReader("nogoal.txt");
        new Maze(reader);

    }
}