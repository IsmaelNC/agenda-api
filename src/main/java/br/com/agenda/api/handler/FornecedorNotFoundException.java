package br.com.agenda.api.handler;

/**
 * @author ismaelnc
 *
 */
public class FornecedorNotFoundException extends RuntimeException {
	
	public FornecedorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
