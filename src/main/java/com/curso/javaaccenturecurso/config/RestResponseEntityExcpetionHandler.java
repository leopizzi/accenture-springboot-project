package com.curso.javaaccenturecurso.config;

import com.curso.javaaccenturecurso.exception.ValidationException;
import com.curso.javaaccenturecurso.model.RetornoPadrao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExcpetionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ValidationException.class})
    protected ResponseEntity<Object> handlerValidatorException(ValidationException e) {
        String erroValidacao = e.getMessage();
        RetornoPadrao retorno = new RetornoPadrao();
        retorno.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        retorno.setMensagem(erroValidacao);

        return new ResponseEntity<Object>(retorno, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
