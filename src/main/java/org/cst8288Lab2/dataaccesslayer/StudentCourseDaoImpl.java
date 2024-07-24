/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.cst8288Lab2.businesslayer.DataValidation;
import org.cst8288Lab2.businesslayer.ValidationException;
import org.cst8288Lab2.transferobjects.StudentCourseDTO;

/**
 * This class implements the StudentCourseDao interface to import items into StudentCourse table.
 * 
 * Date: 7 July, 2024
 * 
 * @author yao yi
 */
public class StudentCourseDaoImpl {
    
    private DataValidation validator = new DataValidation();
    
    /**
     * Override the importStudentCourse method from StudentCourseDao that inserts data into StudentCourse table.
     *
     * @param studentCourse The {@link StudentCourseDTO} object containing the data to be imported.
     */
    public void importStudentCourse(StudentCourseDTO studentCourse) throws ValidationException {
        Connection con;
        PreparedStatement pstmt;
        
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO StudentCourse (studentId, courseId, term, year) "
                    + "VALUES(?, ?, ?, ?)");
            pstmt.setInt(1, studentCourse.getStudentId());
            pstmt.setString(2, studentCourse.getCourseId());
            pstmt.setInt(3, validator.validateTerm(studentCourse.getTerm()));
            pstmt.setInt(4, studentCourse.getYear());
            pstmt.executeUpdate();   
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }   
}
