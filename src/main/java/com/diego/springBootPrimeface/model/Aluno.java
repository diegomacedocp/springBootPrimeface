package com.diego.springBootPrimeface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Aluno{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricula;
    private String nome;
    private String telefone;
    private String email;
    private Instant dataCadastro;

}
