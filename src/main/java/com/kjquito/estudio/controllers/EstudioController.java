package com.kjquito.estudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kjquito.estudio.entity.EstudioEntity;
import com.kjquito.estudio.services.EstudioService;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api")
public class EstudioController {
	
	@Autowired
	private EstudioService estudioService;

	
	@GetMapping("/estudio")
	@ResponseStatus(HttpStatus.OK)
	public List<EstudioEntity> getAll() {
		return estudioService.findAll();
	}
	
	@GetMapping("/estudio/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstudioEntity getById(@PathVariable Long id) {
		return estudioService.findById(id);
	}

	@PostMapping("/estudio")
	@ResponseStatus(HttpStatus.CREATED)
	public EstudioEntity save(@RequestBody EstudioEntity estudio) {
		return estudioService.save(estudio);
	}

	@PutMapping("/estudio/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public EstudioEntity updateById(@RequestBody EstudioEntity estudio, @PathVariable Long id) {
		EstudioEntity estudioDB = estudioService.findById(id);
		estudioDB.setNombre(estudio.getNombre());
		estudioDB.setPrecio(estudio.getPrecio());
		estudioDB.setCategoriaEntity(estudio.getCategoriaEntity());
		return estudioService.save(estudioDB);
	}

	@DeleteMapping("/estudio/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		estudioService.deleteById(id);
	}
}
