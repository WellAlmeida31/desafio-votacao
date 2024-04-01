package br.com.dbserver.assembleia.infrastructure.web.handler.exception;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class AssembleiaValidationException extends RuntimeException implements Serializable {
    public AssembleiaValidationException(String message) {
        super(message);
    }
}
