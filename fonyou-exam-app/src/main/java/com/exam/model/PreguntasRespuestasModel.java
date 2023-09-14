package com.exam.model;

import java.util.List;
import com.exam.entity.RespuestasPreguntasEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreguntasRespuestasModel {
	
	/**
	 * pregunta del examen
	 */
	private String pregunta;
	
	/**
	 * respuestas disponibles
	 */
	private List<RespuestasPreguntasEntity> respuestas;
	
}
