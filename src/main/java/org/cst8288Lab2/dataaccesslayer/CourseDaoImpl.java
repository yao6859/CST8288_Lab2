/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.cst8288Lab2.transferobjects.CourseDTO;

/**
 * This class implements the CourseDao interface to import items into Course table.
 * 
 * Date: 7 July, 2024
 * 
 * @author yao yi
 */
public class CourseDaoImpl {
    
    /**
     * Override the importCourse method from StudentDao that inserts data into Course table.
     *
     * @param course The {@link CourseDTO} object containing the data to be imported.
     */
    public void importCourse(CourseDTO course) {
        Connection con ;
        PreparedStatement pstmt;
        
        try {
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement(
                    "INSERT INTO Course (courseId, courseName) "
                    + "VALUES(?, ?)");
            pstmt.setString(1, course.getCourseId());
            pstmt.setString(2, course.getCourseName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }   
}
