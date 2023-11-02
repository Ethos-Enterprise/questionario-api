package com.ethos.questionarioapi.controller;

import com.ethos.questionarioapi.service.QuestionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/v1.0/questionarios")
@RequiredArgsConstructor
public class QuestionarioController {

    private final QuestionarioService questionarioService;

    @PutMapping("/{fkEmpresa}/refazer")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void refazerQuestionario(@RequestParam String areaEsg, @PathVariable UUID fkEmpresa){
        questionarioService.refazerQuestionario(areaEsg, fkEmpresa);
    }
}
