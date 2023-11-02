package com.ethos.questionarioapi.controller.request;

import lombok.Data;

import java.util.UUID;

@Data
public class PerguntaRequest {
    private Integer id;
    private String areaEsg;
    private String alternativaEscolhida;
    private UUID fkEmpresa;
}
