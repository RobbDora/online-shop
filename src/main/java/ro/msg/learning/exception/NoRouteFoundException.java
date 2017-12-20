package ro.msg.learning.exception;

public class NoRouteFoundException extends RuntimeException {

    public NoRouteFoundException() {
        super();
    }

    public NoRouteFoundException(String message) {
        super(message);
    }

}
