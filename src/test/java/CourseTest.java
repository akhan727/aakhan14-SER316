package test.java;

import main.java.Course;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;

public class CourseTest {

    Course oneStudent;
    Course twoStudents;
    Course threeStudents;
    Course fourStudents;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testOneStudent() {
        // One Student
        oneStudent = new Course("SER316");
        oneStudent.set_points("Hanna", 50);
        double ans = oneStudent.calcAverageNoMinMax();
        assertTrue(ans == 50.0);
    }

    @Test
    public void testTwoStudents() {
        // Two Students
        twoStudents = new Course("SER222");
        twoStudents.set_points("Greg", 60);
        twoStudents.set_points("Bob", 40);
        double ans = twoStudents.calcAverageNoMinMax();
        assertTrue(ans == 50.0);
    }

    @Test
    public void testThreeStudents() {
        // Three Students
        threeStudents = new Course("SER333");
        threeStudents.set_points("Ken", -30);
        threeStudents.set_points("Len", 40);
        threeStudents.set_points("Ben", 50);
        double ans = threeStudents.calcAverageNoMinMax();
        assertTrue(ans == 45.0);
    }

    @Test
    public void testFourStudents() {
        // Four Students
        fourStudents = new Course("SER444");
        fourStudents.set_points("Jill", 99);
        fourStudents.set_points("Cara", 41);
        fourStudents.set_points("Lana", 61);
        fourStudents.set_points("Beth", 12);
        double ans = fourStudents.calcAverageNoMinMax();
        assertTrue(ans == 51.0);
    }
}
