package ro.msg.learning.exception;


public class UserIsAlreadyAdminException extends RuntimeException {

    public UserIsAlreadyAdminException() {
        super();
    }

    public UserIsAlreadyAdminException(String message) {
        super(message);
    }
}
