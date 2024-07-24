/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.businesslayer;

/**
 * Exception thrown for validation errors in data processing.
 * 
 * @author yao yi
 */
public class ValidationException extends Exception{
    
    /**
     * Constructs a new validation exception with the specified detail message.
     * 
     * @param message The detail message.
     */
    public ValidationException(String message) {
        super(message);
    }
    
}
