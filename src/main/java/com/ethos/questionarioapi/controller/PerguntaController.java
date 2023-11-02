package com.ethos.questionarioapi.controller;

import com.ethos.questionarioapi.controller.response.PerguntaResponse;
import com.ethos.questionarioapi.repository.entity.PerguntaEntity;
import com.ethos.questionarioapi.service.PerguntaService;
import com.ethos.questionarioapi.service.QuestionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1.0/perguntas")
@RequiredArgsConstructor
public class PerguntaController {

    private final PerguntaService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<PerguntaResponse> getAllPerguntas() {
        return service.getAllPerguntas();
    }

    // Endpoint principal
    // Caso o front for passar o parâmetro da área ESG
    @GetMapping("/area-esg")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PerguntaResponse> getPerguntasByAreaEsg(@RequestParam String areaEsg) {
        return service.getPerguntasByAreaEsg(areaEsg);
    }

    // Endpoint opcional
    // Caso o front queira buscar as perguntas sem passar nenhum parâmetro
    @GetMapping("/ambiental")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PerguntaResponse> getPerguntasByAreaEsgAmbiental() {
        return service.getPerguntasByAreaEsgContainsAmbiental();
    }

    // Endpoint opcional
    // Caso o front queira buscar as perguntas sem passar nenhum parâmetro
    @GetMapping("/social")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PerguntaResponse> getPerguntasByAreaEsgSocial() {
        return service.getPerguntasByAreaEsgContainsSocial();
    }

    // Endpoint opcional
    // Caso o front queira buscar as perguntas sem passar nenhum parâmetro
    @GetMapping("/governanca")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PerguntaResponse> getPerguntasByAreaEsgGovernanca() {
        return service.getPerguntasByAreaEsgContainsGovernanca();
    }
}
