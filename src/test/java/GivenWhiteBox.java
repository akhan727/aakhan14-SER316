package test.java;

import static org.junit.Assert.*;
import main.java.Course;
import org.junit.Before;
import org.junit.Test;

public class GivenWhiteBox {
    Course oneStudent;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAverageWithoutMinWithoutMax() {
        // One Student
        oneStudent = new Course("SER316");
        oneStudent.set_points("Hanna", 50);
        double ans = oneStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 50.0);
    }
}
