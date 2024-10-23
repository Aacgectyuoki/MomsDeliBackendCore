package com.momsdeli.online.exception;

/**
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
/**
 * Exception thrown when a product is not found in the database.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}