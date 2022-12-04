package it.marjanjovanovicbe.configuration;

import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MyEntityAlreadyExistsException.class, MyEntityInvalidParamException.class, MyEntityNotFoundException.class})
    public ResponseEntity<Object> handle(MyEntityAlreadyExistsException e, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, returnBindingResultErrors(ex), headers, status, request);
    }

    private static Map<String, Object> returnBindingResultErrors(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<String, Object>();
        for (FieldError error : ex.getBindingResult().getFieldErrors())
            errors.put(error.getField(), error.getDefaultMessage());
        for (ObjectError error : ex.getBindingResult().getGlobalErrors())
            errors.put(error.getObjectName(), error.getDefaultMessage());
        return errors;
    }
}