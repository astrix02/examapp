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
import lombok.Getter;

@Data
@Entity
@Table(name = "RESPUESTAS_PREGUNTAS")
public class RespuestasPreguntasEntity {
	
	/**
	 * Identificador de la opcion de respuesta
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int respuestaPreguntaId;
	
	/**
	 * pregunta a la que pertenece la opcion de repuesta
	 */
	private int preguntaId;
	
	/**
	 * examen al que pertenece la opcion de repuesta
	 */
	private int examenId;
	
	/**
	 * puntaje de la opcion de repuesta
	 */
	private int puntaje;
	
	/**
	 * si es correcta la opcion de respuesta
	 */
	private Boolean correcta;
	
	/**
	 * respuesta en texto
	 */
	private String respuesta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "preguntaId", insertable = false, updatable = false)
	private PreguntasEntity pregunta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "examenId", insertable = false, updatable = false)
	private ExamenesEntity examen;
}
