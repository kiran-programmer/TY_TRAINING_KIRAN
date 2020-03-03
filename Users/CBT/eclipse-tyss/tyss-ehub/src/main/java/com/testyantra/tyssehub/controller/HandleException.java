/*
 * package com.testyantra.tyssehub.controller;
 * 
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.validation.ObjectError; import
 * org.springframework.web.bind.MethodArgumentNotValidException; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.bind.annotation.RestControllerAdvice; import
 * org.springframework.web.context.request.WebRequest; import
 * org.springframework.web.servlet.mvc.method.annotation.
 * ResponseEntityExceptionHandler;
 * 
 * import com.testyantra.tyssehub.dto.ErrorResponse;
 * 
 * @RestControllerAdvice public class HandleException extends
 * ResponseEntityExceptionHandler{
 * 
 * @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
 * handleAllException(Exception ex, WebRequest request) { List<String>
 * details=new ArrayList<>(); details.add(ex.getLocalizedMessage());
 * ErrorResponse resp=new ErrorResponse(); resp.setMessage("server errror");
 * resp.setDetails(details); return new ResponseEntity<Object>(resp,
 * HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * 
 * 
 * @ExceptionHandler(RecordNotFoundException.class) public final
 * ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException
 * ex, WebRequest request) { List<String> details = new ArrayList<>();
 * details.add(ex.getLocalizedMessage()); ErrorResponse error = new
 * ErrorResponse(); error.setMessage("Record not found");
 * error.setDetails(details); return new ResponseEntity<Object>(error,
 * HttpStatus.NOT_FOUND); }
 * 
 * @Override protected ResponseEntity<Object>
 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
 * headers, HttpStatus status, WebRequest request) { List<String> details = new
 * ArrayList<>(); for(ObjectError error : ex.getBindingResult().getAllErrors())
 * { details.add(error.getDefaultMessage()); } ErrorResponse error = new
 * ErrorResponse(); error.setMessage("validation failed");
 * error.setDetails(details); return new ResponseEntity<Object>(error,
 * HttpStatus.BAD_REQUEST); }
 * 
 * 
 * }
 */