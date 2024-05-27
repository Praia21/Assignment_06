import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Unitest3 {
    @Test
    public void testCalcStudentsAverage() {
        Department department = new Department("CS");
        Course course = new Course();
        int[] expResult = {73};
        int[] result = course.calcStudentsAverage();
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testCalcStudentsAverage2() {
        Department department = new Department("CS");
        Course course = new Course();
        int[] expResult = {73};
        int[] result = course.calcStudentsAverage();
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testCalcStudentsAverage3() {
        Department department = new Department("CS");
        Course course = new Course();
        int[] expResult = {73};
        int[] result = course.calcStudentsAverage();
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testCalcStudentsAverage4() {
        Department department = new Department("CS");
        Course course = new Course();
        int[] expResult = {73};
        int[] result = course.calcStudentsAverage();
        assertArrayEquals(expResult, result);
    }
}
