package ro.msg.learning.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.msg.learning.exception.UserIsAlreadyAdminException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler({UserIsAlreadyAdminException.class })
    protected ResponseEntity<Object> handleUserIsAlreadyAdminException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "User is already admin", new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
