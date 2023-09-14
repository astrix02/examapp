package com.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EXAMENES")
public class ExamenesEntity {
	
	/**
	 * identificador del examen
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int examenId;
	
	/**
	 * tjtulo del examen
	 */
	@Column
	private String titulo;
}
