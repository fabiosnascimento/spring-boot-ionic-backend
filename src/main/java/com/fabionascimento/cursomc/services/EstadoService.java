package com.fabionascimento.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabionascimento.cursomc.domain.Estado;
import com.fabionascimento.cursomc.repositories.EstadoRespository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRespository repo;
	
	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}
