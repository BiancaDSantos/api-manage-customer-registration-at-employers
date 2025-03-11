package br.com.senac.api_manage_customer_registration_at_employers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientRequestException extends RuntimeException {

    public ClientRequestException(final String message) {
        super(message);
    }
}
