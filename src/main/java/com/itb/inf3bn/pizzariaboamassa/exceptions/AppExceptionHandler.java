package com.itb.inf3bn.pizzariaboamassa.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    private static final ZoneId ZONE_BRASIL = ZoneId.of("America/Sao_Paulo");
    private static final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    private static final Map<Class<? extends Exception>, HttpStatus> EXCEPTION_STATUS_MAP = new HashMap<>();

    static {

        EXCEPTION_STATUS_MAP.put(BadRequest.class, HttpStatus.BAD_REQUEST);
        EXCEPTION_STATUS_MAP.put(NotFound.class, HttpStatus.NOT_FOUND);
        EXCEPTION_STATUS_MAP.put(Unauthorized.class, HttpStatus.UNAUTHORIZED);
        EXCEPTION_STATUS_MAP.put(Forbidden.class, HttpStatus.FORBIDDEN);
        EXCEPTION_STATUS_MAP.put(AccessDeniedException.class, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex, HttpServletRequest request) {

        // Define o status (Buscando o status no Array acima, caso não encontre o default será erro 500 (servidor))
        HttpStatus status = EXCEPTION_STATUS_MAP.getOrDefault(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);

        // Define a mensagem
        // Operador ternário ->  "teste lógico" ? "executa caso true" : executa caso false

        String message = (ex instanceof Forbidden || ex instanceof AccessDeniedException)
                ? "Você não tem permissão para acessar este recurso."
                : (ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.toString());

        // Cria ErrorMessage base

        LocalDateTime now = LocalDateTime.now(ZONE_BRASIL);
        String[] messages = message.split(":");
        ErrorMessage errorMessage = new ErrorMessage(now, messages, status);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), status);

    }

}
