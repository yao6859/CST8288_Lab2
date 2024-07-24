/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.transferobjects;

/**
 * This class represents course items, each item includes 2 properties,
 * and each property has its corresponding getter and setter methods.
 * 
 * Date: 6, July, 2024
 * 
 * @author yao yi
 */
public class CourseDTO {
    
    /**
     * The ID of the course.
     */
    private String courseId;

    /**
     * The name of the course.
     */
    private String courseName;

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
     * Gets the name of the course.
     *
     * @return the name of the course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course.
     *
     * @param courseName the name of the course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
