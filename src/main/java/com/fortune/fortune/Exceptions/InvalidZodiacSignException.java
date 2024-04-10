package com.fortune.fortune.Exceptions;

public class InvalidZodiacSignException extends RuntimeException {

    public InvalidZodiacSignException() {
        super();
    }

    public InvalidZodiacSignException(String message) {
        super(message);
    }

    public InvalidZodiacSignException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidZodiacSignException(Throwable cause) {
        super(cause);
    }
}
