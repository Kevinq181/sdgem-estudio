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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kjquito.estudio.entity.CategoriaEntity;
import com.kjquito.estudio.services.CategoriaService;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
public class CategoriaController {
	
	@Autowired
	public CategoriaService categoriaService;
	
	@CrossOrigin
	@GetMapping("/categoria")
	@ResponseStatus(HttpStatus.OK)
	public List<CategoriaEntity> getAll() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/categoria/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CategoriaEntity getById(@PathVariable Long id) {
		return categoriaService.findById(id);
	}

	@PostMapping("/categoria")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaEntity save(@RequestBody CategoriaEntity categoria) {
		return categoriaService.save(categoria);
	}

	@PutMapping("/categoria/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaEntity updateById(@RequestBody CategoriaEntity categoria, @PathVariable Long id) {
		CategoriaEntity institucionDB = categoriaService.findById(id);
		institucionDB.setNombre(categoria.getNombre());
		return categoriaService.save(institucionDB);
	}

	@DeleteMapping("/categoria/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		categoriaService.deleteById(id);
	}
}
