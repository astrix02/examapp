package com.exam.service;

import java.util.List;

import com.exam.entity.AsignacionesEntity;
import com.exam.entity.EstudiantesEntity;
import com.exam.entity.RespuestasEntity;
import com.exam.model.AsignarExamenModel;
import com.exam.model.CalificarExamenModel;
import com.exam.model.CrearEstudianteModel;
import com.exam.model.CrearExamenModel;
import com.exam.model.ResponderExamenModel;

public interface ExamService {
	
	CrearExamenModel crearExamen(CrearExamenModel crearExamenRequest);
	
	CrearEstudianteModel crearEstudiante(CrearEstudianteModel crearEstudianteRequest);
	
	List<EstudiantesEntity> getEstudiante();
	
	AsignacionesEntity asignarExamen(AsignarExamenModel asignarExamenRequest);
	
	List<RespuestasEntity> responderExamen(ResponderExamenModel responderExamenRequest);
	
	double calificarExamen(CalificarExamenModel calificarExamenRequest);
}
