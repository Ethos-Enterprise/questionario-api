package com.ethos.questionarioapi.service;

import com.ethos.questionarioapi.repository.QuestionarioRepository;
import com.ethos.questionarioapi.repository.entity.PerguntaEntity;
import com.ethos.questionarioapi.repository.entity.QuestionarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuestionarioService {

    private final QuestionarioRepository questionarioRepository;

    public QuestionarioEntity getByFkEmpresa(UUID fkEmpresa){
        return questionarioRepository.findByFkEmpresa(fkEmpresa).orElse(null);
    }

    public QuestionarioEntity postQuestionario(String areaEsg, int porcentagem, UUID fkEmpresa){
        QuestionarioEntity questionarioEntity = new QuestionarioEntity();

        if (areaEsg.equalsIgnoreCase("ambiental")){
            questionarioEntity.setPorcentagemAmbiental(porcentagem);
        } else if (areaEsg.equalsIgnoreCase("social")) {
            questionarioEntity.setPorcentagemSocial(porcentagem);
        } else {
            questionarioEntity.setPorcentagemGovernanca(porcentagem);
        }

        questionarioEntity.setFkEmpresa(fkEmpresa);
        return questionarioRepository.save(questionarioEntity);
    }

    public void atualizarQuestionario(String areaEsg, int pontuacao, QuestionarioEntity questionarioEntity) {

        if (areaEsg.equalsIgnoreCase("ambiental")){
            questionarioEntity.setPorcentagemAmbiental(pontuacao += questionarioEntity.getPorcentagemAmbiental());
        } else if (areaEsg.equalsIgnoreCase("social")) {
            questionarioEntity.setPorcentagemSocial(pontuacao += questionarioEntity.getPorcentagemSocial());
        } else {
            questionarioEntity.setPorcentagemGovernanca(pontuacao += questionarioEntity.getPorcentagemGovernanca());
        }

        questionarioRepository.save(questionarioEntity);
    }

    public void refazerQuestionario(String areaEsg, UUID fkEmpresa){

        QuestionarioEntity questionarioEntity = getByFkEmpresa(fkEmpresa);

        if (areaEsg.equalsIgnoreCase("ambiental")){
            questionarioEntity.setPorcentagemAmbiental(0);
        } else if (areaEsg.equalsIgnoreCase("social")) {
            questionarioEntity.setPorcentagemSocial(0);
        } else {
            questionarioEntity.setPorcentagemGovernanca(0);
        }

        questionarioRepository.save(questionarioEntity);
    }
}
