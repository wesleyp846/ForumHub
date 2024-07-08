package com.forum.ForumHub.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErrorValidation::new).toList());
    }

//    @ExceptionHandler(ValidacaoException.class)
//    public  ResponseEntity tratarErroRegraDeNgocio(ValidacaoException ex){
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }

    private record DadosErrorValidation(String campo, String mensagem){

        public DadosErrorValidation(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
