package com.diego.springBootPrimeface.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.diego.springBootPrimeface.model.Aluno;
import com.diego.springBootPrimeface.model.Curso;
import com.diego.springBootPrimeface.repository.CursoRepositorio;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named(value = "cursoMB")
@ViewScoped
public class CursoMB {

	@Getter
	@Setter
	private List<Curso> cursos = new ArrayList<>();

	@Getter
	@Setter
	private Curso curso;

	@Getter
	@Setter
	private Curso novoCurso;

	public CursoMB() {
		this.novoCurso = new Curso();
	}

	@Autowired
	private CursoRepositorio cursoRepositorio;

	public String salvarCurso() {
		log.info("Salvando novo curso {} no banco de dados", novoCurso.getNome());

		Curso novoCadastro = new Curso(null, novoCurso.getNome(), novoCurso.getEndereco(), novoCurso.getValor(),
				new ArrayList<>());

		cursoRepositorio.save(novoCadastro);

		String msg = "Curso registrado com sucesso";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado", msg));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		cursos.add(novoCadastro);

		return "registration.jsf?faces-redirect=true";
	}

	@PostConstruct
	public List<Curso> listarTodos() {
		cursos = cursoRepositorio.findAll();
		return cursos;
	}

	public Collection<Aluno> listarAlunos() {
		return curso.getAlunos();
	}

	public Integer getTamanhoDaLista() {
		return cursos.size();
	}

	public void setTamanhoDaLista(Integer size) {
		// Método criado para ser utilizado pelo primefaces
	}
}
