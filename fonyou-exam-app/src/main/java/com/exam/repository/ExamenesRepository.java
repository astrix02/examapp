package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.ExamenesEntity;

public interface ExamenesRepository extends JpaRepository<ExamenesEntity, Integer>{
	
}
