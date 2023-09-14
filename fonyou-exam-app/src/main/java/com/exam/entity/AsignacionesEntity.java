package com.exam.entity;

import java.util.Date;

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
@Table(name = "ASIGNACIONES")
public class AsignacionesEntity {
	
	/**
	 * Identificador de asignacion
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int asignacionId;
	
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "examenId", insertable = false, updatable = false)
	private ExamenesEntity examen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estudianteId", insertable = false, updatable = false)
	private EstudiantesEntity estudiante;
}
