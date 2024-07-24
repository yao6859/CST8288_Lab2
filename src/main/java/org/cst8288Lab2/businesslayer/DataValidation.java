/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.businesslayer;

import java.util.regex.Pattern;

/**
 * This class is to validate data
 * 
 * Date: 10 July, 2024
 *
 * @author yao yi
 */
public class DataValidation {
    
    private static final int STUDENT_ID_LENGTH = 9;
    private static final Pattern COURSE_ID_PATTERN = Pattern.compile("^[A-Za-z]{3}\\d{4}$");
    private static final String[] TERMS = {"WINTER", "SUMMER", "FALL"};
    private static final int YEAR_MIN = 1967;
    private static final int YEAR_MAX = 2024;

    /**
    * Implement validation of each filed
    */
    public void validate(String[] data) throws ValidationException {
        String studentId = data[0].trim();
        String courseId = data[3].trim();
        String term = data[5].trim();
        String year = data[6].trim();

        validateStudentId(studentId);
        validateCourseId(courseId);
        validateTerm(term);
        validateYear(year);
    }

    /**
    * Validates the student ID.
    * 
    * @param studentId The student ID to validate.
    * @throws ValidationException If the student ID is invalid.
    */
    private void validateStudentId(String studentId) throws ValidationException {
        if (studentId.length() != STUDENT_ID_LENGTH || !studentId.matches("\\d{" + STUDENT_ID_LENGTH + "}")) {
            throw new ValidationException("Invalid studentId: " + studentId);
        }
    }

    /**
    * Validates the course ID.
    * 
    * @param courseId The course ID to validate.
    * @throws ValidationException If the course ID is invalid.
    */
    private void validateCourseId(String courseId) throws ValidationException {
        if (!COURSE_ID_PATTERN.matcher(courseId).matches()) {
            throw new ValidationException("Invalid courseId: " + courseId);
        }
    }

    /**
    * Validates the term against predefined terms.
    * 
    * @param term The term to validate.
    * @return The index of the term (1-based) if valid.
    * @throws ValidationException If the term is invalid.
    */
    public int validateTerm(String term) throws ValidationException {
        for (int i = 0; i < TERMS.length; i++) {
            if (TERMS[i].equals(term)) {
                return i + 1;
            }
        }
        throw new ValidationException("Invalid term: " + term);
    }

    /**
    * Validates the year to be within a specified range.
    * 
    * @param year The year to validate.
    * @throws ValidationException If the year is invalid or out of range.
    */
    private void validateYear(String year) throws ValidationException {
        if (year.length() != 4 || !year.matches("\\d{4}")) {
            throw new ValidationException("Invalid year: " + year);
        }
        int yearInt = Integer.parseInt(year);
        if (yearInt < YEAR_MIN || yearInt > YEAR_MAX) {
            throw new ValidationException("Invalid year: " + year);
        }
    }

}
