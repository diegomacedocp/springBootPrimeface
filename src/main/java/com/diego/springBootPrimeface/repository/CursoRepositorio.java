package com.diego.springBootPrimeface.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.springBootPrimeface.model.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{
}
