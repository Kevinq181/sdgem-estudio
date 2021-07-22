package com.kjquito.estudio.services;

import java.util.List;

import com.kjquito.estudio.entity.EstudioEntity;


public interface EstudioService {
	public List<EstudioEntity> findAll();

	public EstudioEntity findById(Long id);

	public EstudioEntity save(EstudioEntity estudioEntity);

	public void deleteById(Long id);

}
