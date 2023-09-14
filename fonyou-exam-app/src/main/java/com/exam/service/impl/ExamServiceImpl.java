package com.exam.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exam.entity.AsignacionesEntity;
import com.exam.entity.EstudiantesEntity;
import com.exam.entity.ExamenesEntity;
import com.exam.entity.PreguntasEntity;
import com.exam.entity.RespuestasEntity;
import com.exam.entity.RespuestasPreguntasEntity;
import com.exam.exception.ErrorValidacionDatosException;
import com.exam.model.AsignarExamenModel;
import com.exam.model.CalificarExamenModel;
import com.exam.model.CrearEstudianteModel;
import com.exam.model.CrearExamenModel;
import com.exam.model.PreguntasRespuestasModel;
import com.exam.model.ResponderExamenModel;
import com.exam.repository.AsignacionesRepository;
import com.exam.repository.EstudiantesRepository;
import com.exam.repository.ExamenesRepository;
import com.exam.repository.PreguntasRepository;
import com.exam.repository.RespuestasPreguntasRepository;
import com.exam.repository.RespuestasRepository;
import com.exam.service.ExamService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ExamServiceImpl implements ExamService{
	
	@Autowired
	private ExamenesRepository examenesRepository;
	
	@Autowired
	private PreguntasRepository preguntasRepository;
	
	@Autowired
	private RespuestasPreguntasRepository respuestasPreguntasRepository;
	
	@Autowired
	private EstudiantesRepository estudiantesRepository;
	
	@Autowired
	private AsignacionesRepository asignacionesRepository;
	
	@Autowired
	private RespuestasRepository respuestasRepository;
	
	@Value("${mensaje.error.puntaje}")
	private String errorPuntaje;
	
	@Value("${mensaje.error.respuestas}")
	private String errorCantidadRespuestas;
	
	@Override
	public CrearExamenModel crearExamen(CrearExamenModel crearExamenRequest) {
		
		ExamenesEntity savedExamen = crearExamenBd(crearExamenRequest);
		
		for (PreguntasRespuestasModel preguntas : crearExamenRequest.getPreguntas()) {
			
			PreguntasEntity pregunta = new PreguntasEntity();
			pregunta.setExamenId(savedExamen.getExamenId());
			pregunta.setPregunta(preguntas.getPregunta());
			PreguntasEntity savedPregunta = this.preguntasRepository.save(pregunta);
			
			for (RespuestasPreguntasEntity respuesta : preguntas.getRespuestas()) {
				respuesta.setExamenId(savedExamen.getExamenId());
				respuesta.setPreguntaId(savedPregunta.getPreguntaId());
				this.respuestasPreguntasRepository.save(respuesta);
			}
		}
		
		return crearExamenRequest;
	}

	private ExamenesEntity crearExamenBd(CrearExamenModel crearExamenRequest) {
		ExamenesEntity examen = new ExamenesEntity();
		examen.setTitulo(crearExamenRequest.getTituloExamen());
		ExamenesEntity savedExamen = this.examenesRepository.save(examen);
		log.info("Examen creado");
		return savedExamen;
	}

	@Override
	public CrearEstudianteModel crearEstudiante(CrearEstudianteModel crearEstudianteRequest) {
		
		EstudiantesEntity estudiante =  new EstudiantesEntity();
		estudiante.setNombre(crearEstudianteRequest.getNombre());
		estudiante.setEdad(crearEstudianteRequest.getEdad());
		estudiante.setCiudad(crearEstudianteRequest.getCiudad());
		estudiante.setZonaHoraria(crearEstudianteRequest.getZonaHoraria());
		
		this.estudiantesRepository.save(estudiante);
		
		return crearEstudianteRequest;
	}

	@Override
	public List<EstudiantesEntity> getEstudiante() {
		List<EstudiantesEntity> estudiantes = new ArrayList<EstudiantesEntity>();
		this.estudiantesRepository.findAll().forEach(estudiantes::add);
		return estudiantes;
	}

	@Override
	public AsignacionesEntity asignarExamen(AsignarExamenModel asignarExamenRequest) {
		
		AsignacionesEntity asignacion = new AsignacionesEntity();
		asignacion.setExamenId(asignarExamenRequest.getExamenId());
		asignacion.setEstudianteId(asignarExamenRequest.getEstudianteId());
		
		Optional<EstudiantesEntity> estudianteOptional = this.estudiantesRepository.findById(asignarExamenRequest.getEstudianteId());
		EstudiantesEntity estudiante = estudianteOptional.get();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(asignarExamenRequest.getFecha());
		calendar.setTimeZone(TimeZone.getTimeZone(estudiante.getZonaHoraria()));
		asignacion.setFecha(calendar.getTime());
		
		AsignacionesEntity asignacionSaved = this.asignacionesRepository.save(asignacion);
		
		return asignacionSaved;
	}

	@Override
	public List<RespuestasEntity> responderExamen(ResponderExamenModel responderExamenRequest) {
		
		List<RespuestasEntity> respuestas = new ArrayList<RespuestasEntity>();
		
		for (RespuestasEntity respuesta : responderExamenRequest.getRespuestas()) {
			RespuestasEntity savedRespuesta = this.respuestasRepository.save(respuesta);
			respuestas.add(savedRespuesta);
		}
		
		return respuestas;
	}

	@Override
	public double calificarExamen(CalificarExamenModel calificarExamenRequest) {
		AsignacionesEntity asignacion = this.asignacionesRepository.findByAsignacionIdAndEstudianteId(calificarExamenRequest.getAsignacionId(), calificarExamenRequest.getEstudianteId());
		List<RespuestasEntity> respuestas = this.respuestasRepository.findByAsignacionId(asignacion.getAsignacionId());
		
		if(respuestas.size() == 0) {
			throw new ErrorValidacionDatosException(errorCantidadRespuestas);
		}
		
		double correctas = 0;
		
		for (RespuestasEntity respuesta : respuestas) {
			RespuestasPreguntasEntity respuestaPregunta = respuesta.getRespuestaPregunta();
			if(respuestaPregunta.getCorrecta()) {
				correctas++;
			}
		}
		
		double calificacion = (correctas / respuestas.size()) * 100;
		
		return calificacion;
	}
	
}
