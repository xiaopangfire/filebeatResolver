package com.filebeat.exception;

/**
 * @author Jones chen
 * @Classname FilebeatResolveException
 * @description FilebeatResolveException
 * @since 2022/09/01 16:03
 */
public class FilebeatResolveException extends RuntimeException {
    public FilebeatResolveException() {
    }

    public FilebeatResolveException(String message) {
        super(message);
    }

    public FilebeatResolveException(String message, Throwable cause) {
        super(message, cause);
    }

    public FilebeatResolveException(Throwable cause) {
        super(cause);
    }
}
