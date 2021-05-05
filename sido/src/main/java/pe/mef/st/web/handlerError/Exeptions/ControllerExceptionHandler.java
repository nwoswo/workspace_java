package pe.mef.st.web.handlerError.Exeptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import pe.mef.st.web.handlerError.ResponseMessage;
import pe.mef.st.web.handlerError.RecursoNotFoundException;



@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(RecursoNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseMessage resourceNotFoundException(RecursoNotFoundException ex, WebRequest request) {
    ResponseMessage message = new ResponseMessage(
        HttpStatus.NOT_FOUND.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return message;
  }
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseMessage globalExceptionHandler(Exception ex, WebRequest request) {
	  
    ResponseMessage message = new ResponseMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    ex.printStackTrace();
    return message;
  }

}
