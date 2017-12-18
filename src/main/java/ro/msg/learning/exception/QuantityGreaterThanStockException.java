package ro.msg.learning.exception;

public class QuantityGreaterThanStockException extends RuntimeException{

    public QuantityGreaterThanStockException() {
        super();
    }

    public QuantityGreaterThanStockException(String message) {
        super(message);
    }
}