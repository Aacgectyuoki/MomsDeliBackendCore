package com.momsdeli.online.exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for the application.
 * Handles various exceptions that occur during application runtime.
 * <p>
 * Exception responses are standardized as a Map with an "error" key.
 *
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // Helper method to create a standardized error response
    private ResponseEntity<Map<String, String>> createErrorResponse(String message, HttpStatus status) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", message);
        return new ResponseEntity<>(errorResponse, status);
    }

    // JWT Expired Exception
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Map<String, String>> handleExpiredJwtException(ExpiredJwtException exception) {
        return createErrorResponse("JWT token is expired", HttpStatus.UNAUTHORIZED);
    }

    // Product Not Found Exception
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException exception) {
        return createErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Category Not Found Exception
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        return createErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Invalid Product Data Exception
    @ExceptionHandler(InvalidProductDataException.class)
    public ResponseEntity<Map<String, String>> handleInvalidProductDataException(InvalidProductDataException exception) {
        return createErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Duplicate SKU Exception
    @ExceptionHandler(DuplicateSKUException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateSKUException(DuplicateSKUException ex) {
        return createErrorResponse(ex.getMessage(), HttpStatus.CONFLICT);
    }

    // Max Upload Size Exceeded Exception
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Map<String, String>> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return createErrorResponse("File size exceeds the maximum allowed limit!", HttpStatus.PAYLOAD_TOO_LARGE);
    }

    // Generic Exception Handler for all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception exception) {
        return createErrorResponse("An unexpected error occurred: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
