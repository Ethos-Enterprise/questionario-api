package com.ethos.questionarioapi.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "QUESTIONARIO")
@Entity
public class QuestionarioEntity {
    @Id
    UUID id;
    int porcentagemAmbiental;
    int porcentagemSocial;
    int porcentagemGovernanca;
    UUID fkEmpresa;
}
