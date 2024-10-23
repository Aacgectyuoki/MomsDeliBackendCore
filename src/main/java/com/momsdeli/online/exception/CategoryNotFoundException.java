package com.momsdeli.online.exception;

/**
 * @author Shahbaz Khan
 * @date 29/08/2024
 */

/**
 * Exception thrown when a category is not found in the database.
 */
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}