package com.diego.springBootPrimeface.beans;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.diego.springBootPrimeface.model.Aluno;
import com.diego.springBootPrimeface.model.Curso;
import com.diego.springBootPrimeface.repository.AlunoRepositorio;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Named(value = "alunoMB")
@ViewScoped
public class AlunoMB {

    @Getter
    @Setter
    private List<Aluno> alunos = new ArrayList<>();

    @Getter
    @Setter
    private Aluno aluno;

    @Getter
    @Setter
    private Aluno novoAluno;
    
    public AlunoMB() {
        this.novoAluno = new Aluno();
      }

    @Autowired
    private AlunoRepositorio alunoRepositorio;

    public String salvarAluno(Curso curso) {
    	log.info("Salvando novo aluno {} no banco de dados",novoAluno.getNome());
    	this.novoAluno.setDataCadastro(Instant.now());
    	
    	Aluno novoCadastro = new Aluno(null, novoAluno.getNome(), novoAluno.getEmail(), novoAluno.getTelefone(), novoAluno.getDataCadastro());
    	
        alunoRepositorio.save(novoCadastro);
        
        curso.getAlunos().add(novoCadastro);
        
        String msg = "Usuário Registrado com sucesso";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado", msg));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
        alunos.add(novoCadastro);
        
        return "registration.jsf?faces-redirect=true"; 
    }    
    
    @PostConstruct
    public List<Aluno> listarTodos() {
        alunos = alunoRepositorio.findAll();
        return alunos;
    }

    public Integer getTamanhoDaLista() {
        return alunos.size();
    }

    public void setTamanhoDaLista(Integer size) {
        // Método criado para ser utilizado pelo primefaces
    }
}
