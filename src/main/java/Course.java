package main.java;

/**
 * class for managing course statistics
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Course {

    // maps student names (asurite) to their points
    public HashMap<String, Integer> points = new HashMap<>(); 
    private String name; // course name

    /**
     * Method: Course [Constructor].
     * Inputs: name (String)
     * Returns: name of entered course
     * Description: (Constructor) set the name of the course entered by user
     * */
    public Course(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method: printCourseStats.
     * Inputs: n/a
     * Returns: String
     * Description: Prints out course stats.
     * */
    public void printCourseStats() {    
        // SER316 TASK 2 SPOT-BUGS FIX
        //ArrayList<Integer> values = new ArrayList<Integer>(points.values());
        System.out.print("Average Grades without max and without min: ");
        System.out.println(this.calculateAverageWithoutMinWithoutMax());
    }

    /**
     * Method: calcAverageNoMinMax.
     * Inputs: n/a
     * Returns: average
     * Description: REACH at least 95% Code coverage (assign 3). Method to draw
     * node graph for. Should throw null pointer for empty points member.
     * Negative points should be ignored. Max value and min value should be
     * removed - (if doubles then only the first occurrence). If just one or two
     * values, no values will be omitted.
     * */
    public double calculateAverageWithoutMinWithoutMax() throws NullPointerException {
        ArrayList<Integer> collection = new ArrayList<Integer>(points.values());

        int counter = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (collection.size() == 1) {
            return collection.get(0);
        } else if (collection.size() == 2) {
            return (double)(collection.get(0) + collection.get(1)) / 2;
        } else {
            int allPoints = 0;
            for (int point: collection) {
                if (point >= 0) {
                    // SER316 TASK 2 SPOT-BUGS FIX
                    counter = counter + 1;
                    if (point < min) {
                        min = point;
                    }
                    if (point > max) {
                        max = point;
                    }
                    allPoints = allPoints + point;
                }
            }
            int totalPoints = allPoints - max - min;
            return totalPoints / (double)(counter - 1); 
        }
    }

    /**
     * Method: set_points.
     * Inputs: name (String), points (int)
     * Returns: name (String), points (int)
     * Description: REACH at least 95% Code coverage (assign 3). If student with
     * the name (asurite member) is not yet included, student needs to be added
     * to student list. Sets points for a student.
     * */
    public void set_points(String name, int points) {
        System.out.println(points);
        this.points.put(name, points);
    }

    ArrayList<Student> students  = new ArrayList<Student>();
    
    /**
     * Method: addStudent.
     * Inputs: student (Student)
     * Returns: boolean
     * Description: REACH at least 95% Code coverage (assign 3). Students should
     * only be added when they are not yet in the course (names (asurite member)
     * needs to be unique)
     * */
    public boolean addStudent(Student s) {
        students.add(s);
        points.put(s.getAsurite(), -1);
        return true;
    }

    public HashMap<String, Integer> getPoints() {
        return points;
    }

    public int getStudent_Points(String student) {
        return points.get(student);
    }

    public int getStudent_Points(Student student) {
        return points.get(student.getAsurite());
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Method: countOccurencesLetterGrades.
     * Inputs: n/a
     * Returns: null
     * Description: Calculate how often each letter grade occurs. Calculation
     * is based on the points member inherited from Course. Percentage is
     * calculated by dividing the points by max value in points list. Negative
     * points are discarded.
     * */
    public HashMap<String, Integer> countOccurencesLetterGrades() 
                                      throws NullPointerException {
        return null;
    }
}