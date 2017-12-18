package ro.msg.learning.exception;

public class ProductsLocationsNotFoundException extends RuntimeException{

    public ProductsLocationsNotFoundException() {
        super();
    }

    public ProductsLocationsNotFoundException(String message) {
        super(message);
    }
}
