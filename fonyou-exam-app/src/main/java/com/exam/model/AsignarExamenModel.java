package com.exam.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsignarExamenModel {
	
	/**
	 * Estudiante de la asignacion
	 */
	private int estudianteId;
	
	/**
	 * Examen asignado al estudiante
	 */
	private int examenId;
	
	/**
	 * Fecha del examen
	 */
	private Date fecha;
}
