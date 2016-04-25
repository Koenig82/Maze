/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit class to test the Position Class
 */
public class PositionTest {
    @Test
    public void canCreateNewPosition() throws Exception {

        new Position(1,1);
    }

    @Test
    public void testEqual() throws Exception {

        assertEquals(new Position(1,1), new Position(1,1));
    }

    @Test
    public void testNotEqual() throws Exception {

        assertNotEquals(new Position(1,1), new Position(2,2));
    }

    @Test
    public void hashcodeTest() throws Exception {

        Position a = new Position(1,1);
        Position b = new Position(2,2);

        int hash1 = a.hashCode();
        int hash2 = b.hashCode();

        assertNotEquals(hash1, hash2);
    }

}