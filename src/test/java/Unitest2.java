import org.example.Course;
import org.example.Department;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Unitest2 {
    @Test
    public void testIsAssignmentsTotalWeightValid() {
        Course course = new Course();
        boolean expResult = true;
        boolean result = course.isAssignmentWeightValid();
        assertEquals(expResult, result);
    }
    @Test
    public void testIsAssignmentsTotalWeightValid2() {
        Course course = new Course();
        boolean expResult = true;
        boolean result = course.isAssignmentWeightValid();
        assertEquals(expResult, result);
    }
    @Test
    public void testIsAssignmentsTotalWeightValid3() {
        Course course = new Course();
        boolean expResult = true;
        boolean result = course.isAssignmentWeightValid();
        assertEquals(expResult, result);
    }
}


