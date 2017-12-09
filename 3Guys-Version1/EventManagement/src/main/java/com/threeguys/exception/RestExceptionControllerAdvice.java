package com.threeguys.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionControllerAdvice extends ResponseEntityExceptionHandler {

//	 @ExceptionHandler(MissingInputException.class)
//	  public ResponseEntity<Object> notFoundException(MissingInputException e) {
//	    return error(e, HttpStatus.NOT_FOUND, e.getMessage() );
//	  }
//
//	  private <E extends Exception> ResponseEntity<Object> error(
//	      final E exception, final HttpStatus httpStatus, final String logRef) {
//		  
//	    final String message =  Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
//	    return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
//	  }


	

}
