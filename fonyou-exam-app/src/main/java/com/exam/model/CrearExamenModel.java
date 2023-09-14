package com.exam.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearExamenModel {
	
	/**
	 * titulo del examen
	 */
	private String tituloExamen;
	
	/**
	 * preguntas del examen
	 */
	private List<PreguntasRespuestasModel> preguntas;
}
