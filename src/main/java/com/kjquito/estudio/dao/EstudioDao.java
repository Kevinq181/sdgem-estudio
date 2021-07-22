package com.kjquito.estudio.dao;

import org.springframework.data.repository.CrudRepository;

import com.kjquito.estudio.entity.EstudioEntity;

public interface EstudioDao extends CrudRepository<EstudioEntity, Long>  {

}
