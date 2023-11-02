package com.ethos.questionarioapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PerguntaNaoExisteException extends RuntimeException {
    public PerguntaNaoExisteException(String s) {
    }
}
