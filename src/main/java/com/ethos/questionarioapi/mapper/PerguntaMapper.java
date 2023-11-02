package com.ethos.questionarioapi.mapper;

import com.ethos.questionarioapi.controller.response.PerguntaResponse;
import com.ethos.questionarioapi.repository.entity.PerguntaEntity;

public class PerguntaMapper {

    public static PerguntaResponse toPerguntaResponse(PerguntaEntity entity){
        PerguntaResponse response = new PerguntaResponse();

        response.setId(entity.getId());
        response.setAreaEsg(entity.getAreaEsg());
        response.setTema(entity.getTema());
        response.setTitulo(entity.getTitulo());
        response.setAlternativaA(entity.getAlternativaA());
        response.setAlternativaB(entity.getAlternativaB());
        response.setAlternativaC(entity.getAlternativaC());
        response.setAlternativaD(entity.getAlternativaD());
        response.setAlternativaE(entity.getAlternativaE());

        return response;
    }
}
