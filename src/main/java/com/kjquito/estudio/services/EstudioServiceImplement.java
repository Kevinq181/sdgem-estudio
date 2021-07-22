package com.kjquito.estudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.kjquito.estudio.dao.EstudioDao;
import com.kjquito.estudio.entity.EstudioEntity;

@Service
public class EstudioServiceImplement implements EstudioService {
	@Autowired
	private EstudioDao estudioDao;

	@Override
	public List<EstudioEntity> findAll() {
		return (List<EstudioEntity>) estudioDao.findAll();
	}

	@Override
	public EstudioEntity findById(Long id) {
		return estudioDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("ID de estudio invalido %s", id)));
	}

	@Override
	public EstudioEntity save(EstudioEntity estudioEntity) {
		return estudioDao.save(estudioEntity);
	}

	@Override
	public void deleteById(Long id) {
		estudioDao.deleteById(id);
	}

}
