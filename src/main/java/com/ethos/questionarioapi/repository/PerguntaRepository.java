package com.ethos.questionarioapi.repository;

import com.ethos.questionarioapi.repository.entity.PerguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerguntaRepository extends JpaRepository<PerguntaEntity, Integer> {

    List<PerguntaEntity> findByAreaEsgContainsIgnoreCase(String areaEsg);
}
