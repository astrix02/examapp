package com.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.entity.RespuestasEntity;
import java.util.List;


public interface RespuestasRepository extends CrudRepository<RespuestasEntity, Integer>{
	List<RespuestasEntity> findByAsignacionId(int asignacionId);
}
