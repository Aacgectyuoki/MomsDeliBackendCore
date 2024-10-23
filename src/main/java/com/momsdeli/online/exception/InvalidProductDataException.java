package com.momsdeli.online.exception;

/**
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
/**
 * Exception thrown when product data provided for creation or update is invalid.
 */
public class InvalidProductDataException extends RuntimeException {

    public InvalidProductDataException(String message) {
        super(message);
    }
}