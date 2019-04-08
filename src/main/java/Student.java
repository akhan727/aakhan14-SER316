package main.java;

/*
 * File: Student.java
 * Author: Aaron Khan
 * Date: 4/2/19
 * 
 * Description: This is student class encapsulating all the details for a 
 * student.
 * */

/**
 * Class: Student
 * 
 * Description: This is student class encapsulating all the details for a 
 * student.
 * */

/**
 * Method: 
 * Inputs:
 * Returns:
 * 
 * Description:
 * */

import java.awt.List;
import java.util.ArrayList;

public class Student {
    private String asurite;
    private Major major;
    private double overall_grade;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Course> Courses2 = null;
    
    /**
     * Method: Student [Constructor]
     * Inputs: asurite <String>, major <Major>
     * Returns: instantiated student object
     * 
     * Description: Creates Student object
     * */
    public Student(String asurite, Major major){
        this.setAsurite(asurite);
        this.setMajor(major);
        setOverall_grade(0);
    }

    public String getAsurite() {
         return asurite;
    }

    public void setAsurite(String asurite ) {
        this.asurite = asurite;
    }

    public Major getMajor() {
        return major;
    }
    
    /**
     * Method: registerForCourse
     * Inputs: course <Course>
     * Returns: Course
     * 
     * Description: Creates a course
     * */
    public boolean registerForCourse(Course course) {
      course.addStudent(this);
      return courses.add(course);
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public double getOverall_grade(){
        return overall_grade;
    }

    public void setOverall_grade(double overall_grade) {
        this.overall_grade = overall_grade;
    }
}
