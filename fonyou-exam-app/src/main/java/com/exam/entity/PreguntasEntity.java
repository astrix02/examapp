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
@Table(name = "PREGUNTAS")
public class PreguntasEntity {
	
	/**
	 * identificador de la pregunta
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int preguntaId;
	
	/**
	 * Examen al que pertenece la pregunta
	 */
	private int examenId;
	
	/**
	 * pregunta en texto
	 */
	private String pregunta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "examenId", insertable = false, updatable = false)
	private ExamenesEntity examen;
}
