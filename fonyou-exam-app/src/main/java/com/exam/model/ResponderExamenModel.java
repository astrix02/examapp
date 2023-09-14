package com.exam.model;

import java.util.List;

import com.exam.entity.RespuestasEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponderExamenModel {
	/**
	 * Lista de respuestas del usuario
	 */
	List<RespuestasEntity> respuestas;
}
