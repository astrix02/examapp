package com.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.entity.AsignacionesEntity;
import java.util.List;


public interface AsignacionesRepository extends CrudRepository<AsignacionesEntity, Integer>{
	AsignacionesEntity findByAsignacionIdAndEstudianteId(int asignacionId, int estudianteId);
}
