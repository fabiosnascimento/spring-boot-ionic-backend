package com.fabionascimento.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabionascimento.cursomc.domain.Cidade;
import com.fabionascimento.cursomc.domain.Estado;
import com.fabionascimento.cursomc.dto.CidadeDTO;
import com.fabionascimento.cursomc.dto.EstadoDTO;
import com.fabionascimento.cursomc.services.CidadeService;
import com.fabionascimento.cursomc.services.EstadoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;

	@Autowired
	private CidadeService cidadeService;
	
	@ApiOperation(value="Retorna todos os estados")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value="Retorna todas as cidades de determinado estado")
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
