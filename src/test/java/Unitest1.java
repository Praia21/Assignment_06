import org.example.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Unitest1 {
    @Test
    void testIsPostalCodeValid() {
        String input = "A1B2C3";
        boolean expResult = true;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
    @Test
    void testIsPostalCodeValid2() {
      String input = "A1B 2C3";
      boolean expResult = true;
      boolean result = Address.isPostalCodeValid(input);
    assertEquals(expResult, result);
        }

    @Test
    void testIsPostalCodeValid3() {
      String input = "123456";
      boolean expResult = false;
      boolean result = Address.isPostalCodeValid(input);
      assertEquals(expResult, result);
    }
    @Test
    void testIsPostalCodeValid4() {
      String input = "A1B2C";
      boolean  expResult = false;
      boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
    @Test
    void testIsPostalCodeValid5() {
        String input = "";
        boolean  expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
    @Test
    void testIsPostalCodeValid6() {
        String input = null;
        boolean  expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
}
