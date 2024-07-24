/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.transferobjects;

/**
 * This class represents student items, each item includes 3 properties,
 * and each property has its corresponding getter and setter methods.
 * 
 * Date: 6, July, 2024
 * 
 * @author yao yi
 */
public class StudentDTO {
    
    /**
     * The student's ID.
     */
    private Integer studentId;

    /**
     * The student's first name.
     */
    private String firstName;

    /**
     * The student's last name.
     */
    private String lastName;

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
     * Gets the student's first name.
     *
     * @return the student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName the student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student's last name.
     *
     * @return the student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName the student's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}