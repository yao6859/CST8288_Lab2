/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.cst8288Lab2.dataaccesslayer;

import org.cst8288Lab2.transferobjects.StudentCourseDTO;

/**
 * The interface that contains the method to add items to StudentCourse table
 * 
 * Date: 6 July, 2024
 * 
 * @author yao yi
 */
public interface StudentCourseDao {
    
    void importStudentCourse(StudentCourseDTO studentCourse);
}

