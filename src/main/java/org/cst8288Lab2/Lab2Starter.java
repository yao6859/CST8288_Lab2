/*
 * Main
 */
package org.cst8288Lab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.cst8288Lab2.businesslayer.DataValidation;
import org.cst8288Lab2.businesslayer.ValidationException;
import org.cst8288Lab2.dataaccesslayer.CourseDaoImpl;
import org.cst8288Lab2.dataaccesslayer.StudentCourseDaoImpl;
import org.cst8288Lab2.dataaccesslayer.StudentDaoImpl;
import org.cst8288Lab2.transferobjects.CourseDTO;
import org.cst8288Lab2.transferobjects.StudentCourseDTO;
import org.cst8288Lab2.transferobjects.StudentDTO;

/**
 * starter code for Lab2 
 * 
 * This class reads the csv file, validate data, import data into database, 
 * and generate the error report if data failed the validation.
 */
public class Lab2Starter {
    /**
     * Parses the file: bulk-import.csv
     * Validates each item in each row and updates the database accordingly.
     * @param args - 
     */
    public static void main(String[] args) {
        //Ensure that you use the Properties class to load values from the database.properties file
        Properties dbConnection = new Properties();
        DataValidation validator = new DataValidation();
        StringBuilder importReport = new StringBuilder();
        StringBuilder errorReport = new StringBuilder();
        
        //Preserve this input path
        try (InputStream in = new FileInputStream("data/database.properties")){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(in))){
                String out;
                while ((out = br.readLine()) != null){
                    System.out.println(out.toString());
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // Create objects
        StudentDaoImpl studentDao = new StudentDaoImpl();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        StudentCourseDaoImpl studentCourseDao = new StudentCourseDaoImpl();

        //Preserve this input path
        try (InputStream in = new FileInputStream("data/bulk-import.csv")){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(in))){
                String out;
                boolean isFirstLine = true;
                while ((out = br.readLine()) != null){
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }
                    System.out.println(out.toString());
                    String[] data = out.split(",");
                    
                    try {
                        validator.validate(data);
                        
                        StudentDTO student = new StudentDTO();
                        student.setStudentId(Integer.valueOf(data[0].trim()));
                        student.setFirstName(data[1].trim());
                        student.setLastName(data[2].trim());

                        CourseDTO course = new CourseDTO();
                        course.setCourseId(data[3].trim());
                        course.setCourseName(data[4].trim());

                        StudentCourseDTO studentCourse = new StudentCourseDTO();
                        studentCourse.setStudentId(Integer.valueOf(data[0].trim()));
                        studentCourse.setCourseId(data[3].trim());
                        studentCourse.setTerm(data[5].trim());
                        studentCourse.setYear(Integer.valueOf(data[6].trim()));
                        
                        // import data into database
                        studentDao.importStudent(student);
                        courseDao.importCourse(course);
                        studentCourseDao.importStudentCourse(studentCourse);
                        
                        // Append successful imported data into import-report
                        importReport.append(String.join(",", data)).append("\n");

                    } catch (ValidationException e) {
                        String errorLine = String.join(",", data) + "," + e.getMessage();
                        errorReport.append(errorLine).append("\n");
                    }
                }
                // Generate two reports
                generateImportReport(importReport.toString());
                generateErrorReport(errorReport.toString());
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e){
            e.printStackTrace();
        }           
    }
    
    /**
     * The method to generate import report
     * 
     * @param importReport 
     */
    private static void generateImportReport(String importReport) {
        // Generate import-report.md file
        try (java.io.FileWriter fw = new java.io.FileWriter("import-report.md")) {
            fw.write("# Import Report #\n\n");
            fw.write("The following entries were successfully imported:\n\n");          
            fw.write(importReport);      
            System.out.println("Import report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * The method to generate error report
     * 
     * @param errorReport 
     */
    private static void generateErrorReport(String errorReport) {
        // Generate error-report.md file
        try (java.io.FileWriter fw = new java.io.FileWriter("error-report.md")) {
            fw.write("# Error Report #\n\n");
            fw.write("The following entries were not imported because of validation failure:\n\n");         
            fw.write(errorReport);         
            System.out.println("Error report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

