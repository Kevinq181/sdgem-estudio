package com.kjquito.estudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kjquito.estudio.dao.CategoriaDao;
import com.kjquito.estudio.entity.CategoriaEntity;

@Service
public class CategoriaServiceImplement implements CategoriaService {
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public List<CategoriaEntity> findAll() {
		return (List<CategoriaEntity>) categoriaDao.findAll();
	}

	@Override
	public CategoriaEntity findById(Long id) {
		return categoriaDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("ID de institucion invalido %s", id)));
	}

	@Override
	public CategoriaEntity save(CategoriaEntity categoria) {
		return categoriaDao.save(categoria);
	}

	@Override
	public void deleteById(Long id) {
		categoriaDao.deleteById(id);
	}

}
