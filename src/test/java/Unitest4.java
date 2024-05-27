import org.junit.jupiter.api.Test;
import util.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Unitest4 {
    @Test
    void testToTitleCase() {
        String input = "john doe";
        String expResult = "John Doe";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase2() {
        String input = "";
        String expResult = "";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase3() {
        String input = null;
        String expResult = null;
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }
}
