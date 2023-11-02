package com.ethos.questionarioapi.repository;

import com.ethos.questionarioapi.repository.entity.PerguntaEntity;
import com.ethos.questionarioapi.repository.entity.QuestionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QuestionarioRepository extends JpaRepository<QuestionarioEntity, Integer> {

    Optional<QuestionarioEntity> findByFkEmpresa(UUID fkEmpresa);
}
