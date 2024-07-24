/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.cst8288Lab2.transferobjects.StudentDTO;

/**
 * This class implements the StudentDao interface to import items into Student table.
 * 
 * Date: 7 July, 2024
 * 
 * @author yao yi
 */
public class StudentDaoImpl implements StudentDao {
    
    /**
     * Override the importStudent method from StudentDao that inserts data into Student table.
     *
     * @param student The {@link StudentDTO} object containing the data to be imported.
     */
    @Override
    public void importStudent(StudentDTO student) {
        Connection con;
        PreparedStatement pstmt;
        
        try {
            con = DataSource.getConnection();

            pstmt = con.prepareStatement(
                    "INSERT INTO Student (studentId, firstName, lastName) "
                    + "VALUES(?, ?, ?)");
            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            pstmt.executeUpdate();                   
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
}
