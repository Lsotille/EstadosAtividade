package com.estados.controller;

import com.estados.controller.dto.EstadosDto;
import com.estados.controller.form.EstadosForm;
import com.estados.modelo.Estados;
import com.estados.repository.EstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadosController {
	
	@Autowired
	private EstadosRepository estadosRepository;
	
	@GetMapping
	public List<EstadosDto> lista(String regiao,int populacao, int area) {
		if (regiao != null) {
			List<Estados> estados = estadosRepository.findByRegiao(regiao);
			return EstadosDto.converter(estados);
		}
		if (populacao != 0){
			List<Estados> estados = estadosRepository.ordenarPorPopulacao();
			return EstadosDto.converter(estados);
		}
		if (area != 0){
			List<Estados> estados = estadosRepository.ordenarPorArea();
			return EstadosDto.converter(estados);
		}
		else{
			List<Estados> estados = estadosRepository.findAll();
			return EstadosDto.converter(estados);
		}
	}

	@PostMapping
	public ResponseEntity<EstadosDto> cadastrar(@RequestBody EstadosForm form){
		Estados estados = form.converter();
		estadosRepository.save(estados);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(estados.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadosDto(estados));
	}

	@GetMapping("/{id}")
	public EstadosDto detalhar(@PathVariable Long id){
		Estados estados = estadosRepository.getOne(id);
		return new EstadosDto(estados);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstadosDto> atualizar(@PathVariable Long id,@RequestBody EstadosForm form){
		Estados estados = form.atualizar(id, estadosRepository);
        return ResponseEntity.ok(new EstadosDto(estados));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		estadosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
