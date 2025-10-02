import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tugas4Test {

    // Skenario 1
    @Test
    public void testScenario1() {
        assertEquals(3, Tugas4.findMin(1, 2, 3));
    }

    // Skenario 2
    @Test
    public void testScenario2() {
        assertEquals(-1, Tugas4.findMin(-1, -2, -3));
    }

    // Skenario 3
    @Test
    public void testScenario3() {
        assertEquals(0, Tugas4.findMin(0, 0, 1));
    }
}
