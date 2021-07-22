package com.kjquito.estudio.services;

import java.util.List;

import com.kjquito.estudio.entity.CategoriaEntity;


public interface CategoriaService {
	public List<CategoriaEntity> findAll();

	public CategoriaEntity findById(Long id);

	public CategoriaEntity save(CategoriaEntity institucion);

	public void deleteById(Long id);

}
