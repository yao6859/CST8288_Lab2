/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.transferobjects;

/**
 * This class represents StudentCourse items, each item includes 4 properties,
 * and each property has its corresponding getter and setter methods.
 * 
 * Date: 6, July, 2024
 * 
 * @author yao yi
 */
public class StudentCourseDTO {
    
    /**
     * The student's ID.
     */
    private Integer studentId;
    
    /**
     * The ID of the course.
     */
    private String courseId;
    
    /**
     * The term in which the course is taken.
     */
    private String term;

    /**
     * The year in which the course is taken.
     */
    private Integer year;
    
    /**
     * Gets the student's ID.
     *
     * @return the student's ID
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Sets the student's ID.
     *
     * @param studentId the student's ID
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    /**
     * Gets the ID of the course.
     *
     * @return the ID of the course
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Sets the ID of the course.
     *
     * @param courseId the ID of the course
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    /**
     * Gets the term in which the course is taken.
     *
     * @return the term in which the course is taken
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets the term in which the course is taken.
     *
     * @param term the term in which the course is taken
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Gets the year in which the course is taken.
     *
     * @return the year in which the course is taken
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the year in which the course is taken.
     *
     * @param year the year in which the course is taken
     */
    public void setYear(Integer year) {
        this.year = year;
    }
}
