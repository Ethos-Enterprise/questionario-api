package com.ethos.questionarioapi.controller.response;

import lombok.Data;

import java.util.UUID;

@Data
public class QuestionarioResponse {
    UUID id;
    int porcentagemAmbiental;
    int porcentagemSocial;
    int porcentagemGovernanca;
    UUID fkEmpresa;
}
