package com.ethos.questionarioapi.service;

import com.ethos.questionarioapi.controller.request.PerguntaRequest;
import com.ethos.questionarioapi.controller.response.PerguntaResponse;
import com.ethos.questionarioapi.exception.PerguntaNaoExisteException;
import com.ethos.questionarioapi.mapper.PerguntaMapper;
import com.ethos.questionarioapi.repository.PerguntaRepository;
import com.ethos.questionarioapi.repository.entity.PerguntaEntity;
import com.ethos.questionarioapi.repository.entity.QuestionarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerguntaService {

    private final PerguntaRepository perguntaRepository;
    private final QuestionarioService questionarioService;

    public List<PerguntaResponse> getAllPerguntas() {
        final List<PerguntaEntity> perguntas = perguntaRepository.findAll();
        return perguntas.stream().map(PerguntaMapper::toPerguntaResponse).toList();
    }

    public List<PerguntaResponse> getPerguntasByAreaEsg(String areaEsg) {
        final List<PerguntaEntity> perguntas = perguntaRepository.findByAreaEsgContainsIgnoreCase(areaEsg);
        return perguntas.stream().map(PerguntaMapper::toPerguntaResponse).toList();
    }

    public List<PerguntaResponse> getPerguntasByAreaEsgContainsAmbiental() {
        final List<PerguntaEntity> perguntas = perguntaRepository.findByAreaEsgContainsIgnoreCase("ambiental");
        return perguntas.stream().map(PerguntaMapper::toPerguntaResponse).toList();
    }

    public List<PerguntaResponse> getPerguntasByAreaEsgContainsSocial() {
        final List<PerguntaEntity> perguntas = perguntaRepository.findByAreaEsgContainsIgnoreCase("social");
        return perguntas.stream().map(PerguntaMapper::toPerguntaResponse).toList();
    }

    public List<PerguntaResponse> getPerguntasByAreaEsgContainsGovernanca() {
        final List<PerguntaEntity> perguntas = perguntaRepository.findByAreaEsgContainsIgnoreCase("governanca");
        return perguntas.stream().map(PerguntaMapper::toPerguntaResponse).toList();
    }

    public void somarPorcentagemEsg(PerguntaRequest request){
        final PerguntaEntity pergunta = perguntaRepository.findById(request.getId()).orElseThrow(() -> new PerguntaNaoExisteException("A pergunta não existe.")) ;

        int pontuacao = definePorcentagemEsg(request.getAlternativaEscolhida(), pergunta);

        QuestionarioEntity questionarioEntity = questionarioService.getByFkEmpresa(request.getFkEmpresa());

        if (questionarioEntity == null){
            // Criar o questionário e atribuir a uma empresa
            questionarioService.postQuestionario(request.getAreaEsg(), pontuacao, request.getFkEmpresa());
        } else {
            // Atualizar a porcentagem do questionário que já foi criado
            questionarioService.atualizarQuestionario(request.getAreaEsg(), pontuacao, questionarioEntity);
        }
    }

    private int definePorcentagemEsg(String alternativaEscolhida, PerguntaEntity entity) {
        int porcentagem = 0;

        switch (alternativaEscolhida.toLowerCase()) {
            case "a":
                porcentagem += 2;
                break;
            case "b":
                porcentagem += 4;
                break;
            case "c":
                porcentagem += 6;
                break;
            case "d":
                porcentagem += 8;
                break;
            case "e":
                porcentagem += 10;
                break;
            default:
                porcentagem += 0;
                break;
        }

        return porcentagem;
    }
}
