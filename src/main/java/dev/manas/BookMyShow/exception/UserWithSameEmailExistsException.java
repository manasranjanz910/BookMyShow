package dev.manas.BookMyShow.exception;

public class UserWithSameEmailExistsException extends RuntimeException {
    public UserWithSameEmailExistsException() {
    }
    public UserWithSameEmailExistsException(String message) {
        super(message);
    }
}
