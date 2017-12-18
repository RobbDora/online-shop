/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.msg.learning.exception;

/**
 *
 * @author vagrant
 */
public class ProductWithLargestStockNotFoundException extends RuntimeException{
    
    public ProductWithLargestStockNotFoundException() {
        super();
    }

    public ProductWithLargestStockNotFoundException(String message) {
        super(message);
    }
    
}
