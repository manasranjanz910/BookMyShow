package dev.manas.BookMyShow.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() {
    }
    public InvalidPasswordException(String message) {
        super(message);
    }
}
