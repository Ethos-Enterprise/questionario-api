package com.ethos.questionarioapi.controller.response;

import lombok.Data;

@Data
public class PerguntaResponse {
    Integer id;
    String areaEsg;
    String tema;
    String titulo;
    String alternativaA;
    String alternativaB;
    String alternativaC;
    String alternativaD;
    String alternativaE;
}
