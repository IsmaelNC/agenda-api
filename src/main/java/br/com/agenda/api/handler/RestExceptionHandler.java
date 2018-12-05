/**
 * 
 */
package br.com.agenda.api.handler;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author ismaelnc
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ContatoNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Contato não encontrado", 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
 
    @ExceptionHandler({ ContatoIdMismatchException.class, 
      ConstraintViolationException.class, 
      DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getLocalizedMessage(), 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
	@ExceptionHandler({ ClienteNotFoundException.class })
    protected ResponseEntity<Object> handleNotFoundCliente(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Contato não encontrado", 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
	
    @ExceptionHandler({ ClienteIdMismatchException.class, 
        ConstraintViolationException.class, 
        DataIntegrityViolationException.class })
      public ResponseEntity<Object> handleBadRequestCliente(Exception ex, WebRequest request) {
          return handleExceptionInternal(ex, ex.getLocalizedMessage(), 
            new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
	
	@ExceptionHandler({ FornecedorNotFoundException.class })
    protected ResponseEntity<Object> handleNotFoundFornecedor(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Contato não encontrado", 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
	
    @ExceptionHandler({ FornecedorIdMismatchException.class, 
        ConstraintViolationException.class, 
        DataIntegrityViolationException.class })
      public ResponseEntity<Object> handleBadRequestFornecedor(Exception ex, WebRequest request) {
          return handleExceptionInternal(ex, ex.getLocalizedMessage(), 
            new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
