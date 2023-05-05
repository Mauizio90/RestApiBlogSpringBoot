package eu.mauizio90.RestBlog.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 *
 * @author mauiz
 */
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
    
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(PostNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handlePostNotFoundException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
                "Total errors: " + ex.getErrorCount()+ "; First error: " + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
        
        
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
        
    }
}
