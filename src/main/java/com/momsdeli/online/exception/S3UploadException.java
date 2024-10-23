package com.momsdeli.online.exception;

/**
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
/**
 * Exception thrown when an error occurs during the upload of a file to S3.
 */
public class S3UploadException extends RuntimeException {

    public S3UploadException(String message) {
        super(message);
    }

    public S3UploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
