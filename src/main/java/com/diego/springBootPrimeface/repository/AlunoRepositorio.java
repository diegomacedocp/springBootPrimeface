package com.diego.springBootPrimeface.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.springBootPrimeface.model.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long>{
}
