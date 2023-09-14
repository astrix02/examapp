package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.AsignacionesEntity;
import com.exam.entity.EstudiantesEntity;
import com.exam.entity.RespuestasEntity;
import com.exam.model.AsignarExamenModel;
import com.exam.model.CalificarExamenModel;
import com.exam.model.CrearEstudianteModel;
import com.exam.model.CrearExamenModel;
import com.exam.model.ResponderExamenModel;
import com.exam.service.ExamService;



@RestController
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@PostMapping("/crearExamen")
	public ResponseEntity<CrearExamenModel> crearExamen(@RequestBody CrearExamenModel crearExamenRequest){
		return ResponseEntity.ok().body(this.examService.crearExamen(crearExamenRequest));
	}
	
	@PostMapping("/crearEstudiante")
	public ResponseEntity<CrearEstudianteModel> crearEstudiante(@RequestBody CrearEstudianteModel crearEstudianteRequest){
		return ResponseEntity.ok().body(this.examService.crearEstudiante(crearEstudianteRequest));
	}
	
	@GetMapping("/getEstudiantes")
	public ResponseEntity<List<EstudiantesEntity>> getAllEstudiantes(){
		return ResponseEntity.ok().body(this.examService.getEstudiante());
	}
	
	@PostMapping("/asignarExamen")
	public ResponseEntity<AsignacionesEntity> asignarExamen(@RequestBody AsignarExamenModel asignarExamenRequest){
		return ResponseEntity.ok().body(this.examService.asignarExamen(asignarExamenRequest));
	}
	
	@PostMapping("/responderExamen")
	public ResponseEntity<List<RespuestasEntity>> contestarExamen(@RequestBody ResponderExamenModel responderExamenRequest){
		return ResponseEntity.ok().body(this.examService.responderExamen(responderExamenRequest));
	}
	
	@PostMapping("/calificarExamen")
	public ResponseEntity<Double> calificarExamen(@RequestBody CalificarExamenModel calificarExamenRequest){
		return ResponseEntity.ok().body(this.examService.calificarExamen(calificarExamenRequest));
	}
}
