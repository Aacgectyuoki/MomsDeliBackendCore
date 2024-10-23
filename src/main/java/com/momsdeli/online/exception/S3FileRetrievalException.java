package com.momsdeli.online.exception;

/**
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
/**
 * Exception thrown when an error occurs during the retrieval of a file from S3.
 */
public class S3FileRetrievalException extends RuntimeException {

    public S3FileRetrievalException(String message) {
        super(message);
    }

    public S3FileRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }
}