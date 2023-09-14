package com.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "RESPUESTAS")
public class RespuestasEntity {
	
	/**
	 * Identificador de respuesta
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int respuestaId;
	
	/**
	 * Pregunta contestada
	 */
	private int preguntaId;
	
	/**
	 * asignacion a la que pertenece la pregunta
	 */
	private int asignacionId;
	
	/**
	 * Respuesta de la pregunta
	 */
	private int respuestaPreguntaId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "preguntaId", insertable = false, updatable = false)
	private PreguntasEntity pregunta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "asignacionId", insertable = false, updatable = false)
	private AsignacionesEntity asignacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "respuestaPreguntaId", insertable = false, updatable = false)
	private RespuestasPreguntasEntity respuestaPregunta;
}
