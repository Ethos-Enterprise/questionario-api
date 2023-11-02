package com.ethos.questionarioapi.repository.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERGUNTA")
@Entity
public class PerguntaEntity {
    @Id
    Integer id;
    String areaEsg;
    String tema;
    String titulo;
    String alternativaA;
    String alternativaB;
    String alternativaC;
    String alternativaD;
    String alternativaE;
    UUID fkQuestionario;
}
