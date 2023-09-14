package com.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ESTUDIANTES")
public class EstudiantesEntity {
	
	/**
	 * identificador estudiante
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int estudiante_id;
	
	/**
	 * Nombre del estudiante
	 */
	private String nombre;
	
	/**
	 * edad del estudiante
	 */
	private String edad;
	
	/**
	 * ciudad del estudiante
	 */
	private String ciudad;
	
	/**
	 * zona horaria del estudiante
	 */
	private String zonaHoraria;
}
