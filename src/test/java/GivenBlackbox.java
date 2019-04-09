package test.java;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import main.java.Course;
import main.java.CourseGrades0;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades3;
import main.java.CourseGrades4;
import main.java.CourseGrades5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GivenBlackbox {
    private Class<Course> classUnderTest;


    @SuppressWarnings("unchecked")
    public GivenBlackbox(Object classUnderTest) {
        this.classUnderTest = (Class<Course>) classUnderTest;
    }

    /**
     * Method: courseGradesUnderTest.
     * Inputs: n/a
     * Returns: array list of classes
     * Description: Defining all the classes that need to be tested
     * */
    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = { 
                {CourseGrades0.class},
                {CourseGrades1.class},
                {CourseGrades2.class},
                {CourseGrades3.class},
                {CourseGrades4.class},
                {CourseGrades5.class}
        };
        return Arrays.asList(classes);
    }

    // method to call the correct constructor
    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }

    // Course: Two Student
    Course twoStudent;
    HashMap<String, Integer> twoStudentExpected = new HashMap<String, Integer>(); 

    // Course: Ten Student
    Course tenStudent;
    HashMap<String, Integer> tenStudentExpected = new HashMap<String, Integer>(); 

    // Course: Grade Boundary
    Course gradeBoundary;
    HashMap<String, Integer> gradeBoundaryExpected = new HashMap<String, Integer>(); 

    // Course: High Grades
    Course highGrades;
    HashMap<String, Integer> highGradesExpected = new HashMap<String, Integer>(); 

    // Course: Mostly Lower Grades
    Course mostlyLowerGrades;
    HashMap<String, Integer> mostlyLowerGradesExpected = new HashMap<String, Integer>(); 

    /**
     * Method: setUp.
     * Inputs: n/a
     * Returns: n/a
     * Description: Set up for testing
     * */
    @Before
    public void setUp() throws Exception {

        // Two Student Setup
        twoStudent = createCourse("SER316");
        twoStudent.set_points("Hanna",100);
        twoStudent.set_points("Karla",100);
        twoStudentExpected.put("A", 2);
        twoStudentExpected.put("B", 0);
        twoStudentExpected.put("C", 0);
        twoStudentExpected.put("D", 0);
        twoStudentExpected.put("F", 0);

        // Ten Student Setup
        tenStudent = createCourse("CS222");
        tenStudent.set_points("Timmy",9);
        tenStudent.set_points("Tonya",8);
        tenStudent.set_points("Tasha",7);
        tenStudent.set_points("Terry",6);
        tenStudent.set_points("Tabby",5);
        tenStudent.set_points("Trent",4);
        tenStudent.set_points("Talia",3);
        tenStudent.set_points("Tyson",2);
        tenStudent.set_points("Tammy",1);
        tenStudent.set_points("Teddy",0);
        tenStudentExpected.put("A", 2);
        tenStudentExpected.put("B", 2);
        tenStudentExpected.put("C", 1);
        tenStudentExpected.put("D", 1);
        tenStudentExpected.put("F", 4);

        // Grade Boundary Setup
        gradeBoundary = createCourse("IT102");
        gradeBoundary.set_points("Grace",100);
        gradeBoundary.set_points("Gemma",99);
        gradeBoundary.set_points("Giana",82);
        gradeBoundary.set_points("Garth",81);       
        gradeBoundary.set_points("Gabby",80);
        gradeBoundary.set_points("Garsi",79);
        gradeBoundary.set_points("Ginny",67);
        gradeBoundary.set_points("Giano",66);     
        gradeBoundary.set_points("Galia",65);
        gradeBoundary.set_points("Glenn",64);
        gradeBoundary.set_points("Gayle",52);
        gradeBoundary.set_points("Gotye",51);     
        gradeBoundary.set_points("Gilly",50);
        gradeBoundary.set_points("Gruff",49);
        gradeBoundary.set_points("Gerri",37);
        gradeBoundary.set_points("Gower",36);
        gradeBoundary.set_points("Giada",35);
        gradeBoundary.set_points("Guido",34);
        gradeBoundary.set_points("Greta",1);
        gradeBoundary.set_points("Grant",0);   
        gradeBoundaryExpected.put("A", 4);
        gradeBoundaryExpected.put("B", 4);
        gradeBoundaryExpected.put("C", 4);
        gradeBoundaryExpected.put("D", 4);
        gradeBoundaryExpected.put("F", 4);

        // High Grades Setup
        highGrades = createCourse("CS222");
        highGrades.set_points("Holly",50);
        highGrades.set_points("Henry",49);
        highGrades.set_points("Heidi",48);
        highGrades.set_points("Harry",47);
        highGrades.set_points("Hanna",46);
        highGradesExpected.put("A", 5);
        highGradesExpected.put("B", 0);
        highGradesExpected.put("C", 0);
        highGradesExpected.put("D", 0);
        highGradesExpected.put("F", 0);

        // Mostly Lower Grades Setup
        mostlyLowerGrades = createCourse("CS222");
        mostlyLowerGrades.set_points("Molly",70);
        mostlyLowerGrades.set_points("Macky",24);
        mostlyLowerGrades.set_points("Maddy",23);
        mostlyLowerGrades.set_points("Miles",22);
        mostlyLowerGrades.set_points("Megan",21);
        mostlyLowerGradesExpected.put("A", 1);
        mostlyLowerGradesExpected.put("B", 0);
        mostlyLowerGradesExpected.put("C", 0);
        mostlyLowerGradesExpected.put("D", 0);
        mostlyLowerGradesExpected.put("F", 4);

    }

    // Two Student Test
    @Test
    public void twoStudent() {
        System.out.println("///// Test: Two Student /////");
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(twoStudentExpected));
        System.out.println("");
    }    

    // Ten Student Test
    @Test
    public void tenStudent() {
        System.out.println("///// Test: Ten Student /////");
        HashMap<String, Integer> ans = tenStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(tenStudentExpected));
        System.out.println("");
    }   

    // Grade Boundary Test
    @Test
    public void gradeBoundary() {
        System.out.println("///// Test: Grade Boundary /////");
        HashMap<String, Integer> ans = gradeBoundary.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(gradeBoundaryExpected));
        System.out.println("");
    }

    // High Grades Test
    @Test
    public void highGrades() {
        System.out.println("///// Test: High Grades /////");
        HashMap<String, Integer> ans = highGrades.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(highGradesExpected));
        System.out.println("");
    } 

    // Mostly Lower Grades Test
    @Test
    public void mostlyLowerGrades() {
        System.out.println("///// Test: High Grades /////");
        HashMap<String, Integer> ans = mostlyLowerGrades.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(mostlyLowerGradesExpected));
        System.out.println("");
    } 

}