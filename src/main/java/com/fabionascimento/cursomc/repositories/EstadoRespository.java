package com.fabionascimento.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabionascimento.cursomc.domain.Estado;

@Repository
public interface EstadoRespository extends JpaRepository<Estado, Integer> {

}
