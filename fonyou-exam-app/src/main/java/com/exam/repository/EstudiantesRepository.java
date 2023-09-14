package com.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.entity.EstudiantesEntity;

public interface EstudiantesRepository extends CrudRepository<EstudiantesEntity, Integer>{
	
}
