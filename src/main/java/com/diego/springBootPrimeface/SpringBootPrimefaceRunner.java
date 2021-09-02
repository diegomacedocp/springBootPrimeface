package com.diego.springBootPrimeface;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.diego.springBootPrimeface.model.Curso;
import com.diego.springBootPrimeface.repository.CursoRepositorio;

@Configuration
public class SpringBootPrimefaceRunner implements ApplicationRunner {
	
	@Autowired
    private CursoRepositorio cursoRepositorio;
	
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
    	cursoRepositorio.save(new Curso(null,"React","Indra",(float) 0.00,new ArrayList<>()));
    	cursoRepositorio.save(new Curso(null,"Angular","Indra",(float) 0.00,new ArrayList<>()));
    	cursoRepositorio.save(new Curso(null,"Java","Indra",(float) 0.00,new ArrayList<>()));
		
	}
}
