package com.momsdeli.online.exception;

/**
 * @author Shahbaz Khan
 * @date 08/10/2024
 */
public class DuplicateSKUException extends RuntimeException{


    public DuplicateSKUException(String message) {
        super(message);
    }
}
