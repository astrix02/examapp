CREATE DATABASE `examdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- examdb.estudiantes definition

CREATE TABLE `estudiantes` (
  `estudiante_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `edad` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ciudad` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `zona_horaria` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`estudiante_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- examdb.examenes definition

CREATE TABLE `examenes` (
  `examen_id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`examen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- examdb.asignaciones definition

CREATE TABLE `asignaciones` (
  `asignacion_id` int NOT NULL AUTO_INCREMENT,
  `estudiante_id` int NOT NULL,
  `examen_id` int NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`asignacion_id`),
  KEY `ASIGNACIONES_FK` (`estudiante_id`),
  KEY `ASIGNACIONES_FK_1` (`examen_id`),
  CONSTRAINT `ASIGNACIONES_FK` FOREIGN KEY (`estudiante_id`) REFERENCES `estudiantes` (`estudiante_id`),
  CONSTRAINT `ASIGNACIONES_FK_1` FOREIGN KEY (`examen_id`) REFERENCES `examenes` (`examen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- examdb.preguntas definition

CREATE TABLE `preguntas` (
  `pregunta_id` int NOT NULL AUTO_INCREMENT,
  `examen_id` int NOT NULL,
  `pregunta` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`pregunta_id`),
  KEY `preguntas_FK` (`examen_id`),
  CONSTRAINT `preguntas_FK` FOREIGN KEY (`examen_id`) REFERENCES `examenes` (`examen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- examdb.respuestas_preguntas definition

CREATE TABLE `respuestas_preguntas` (
  `respuesta_pregunta_id` int NOT NULL AUTO_INCREMENT,
  `pregunta_id` int DEFAULT NULL,
  `examen_id` int NOT NULL,
  `puntaje` int NOT NULL,
  `correcta` tinyint(1) DEFAULT '0',
  `respuesta` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`respuesta_pregunta_id`),
  KEY `RESPUESTAS_PREGUNTAS_FK2` (`examen_id`),
  KEY `RESPUESTAS_PREGUNTAS_FK_3` (`pregunta_id`),
  CONSTRAINT `RESPUESTAS_PREGUNTAS_FK2` FOREIGN KEY (`examen_id`) REFERENCES `examenes` (`examen_id`),
  CONSTRAINT `RESPUESTAS_PREGUNTAS_FK_3` FOREIGN KEY (`pregunta_id`) REFERENCES `preguntas` (`pregunta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- examdb.respuestas definition

CREATE TABLE `respuestas` (
  `respuesta_id` int NOT NULL AUTO_INCREMENT,
  `pregunta_id` int NOT NULL,
  `asignacion_id` int NOT NULL,
  `respuesta_pregunta_id` int DEFAULT NULL,
  PRIMARY KEY (`respuesta_id`),
  KEY `RESPUESTAS_FK` (`pregunta_id`),
  KEY `RESPUESTAS_FK_1` (`asignacion_id`),
  KEY `RESPUESTAS_FK_2` (`respuesta_pregunta_id`),
  CONSTRAINT `RESPUESTAS_FK` FOREIGN KEY (`pregunta_id`) REFERENCES `preguntas` (`pregunta_id`),
  CONSTRAINT `RESPUESTAS_FK_1` FOREIGN KEY (`asignacion_id`) REFERENCES `asignaciones` (`asignacion_id`),
  CONSTRAINT `RESPUESTAS_FK_2` FOREIGN KEY (`respuesta_pregunta_id`) REFERENCES `respuestas_preguntas` (`respuesta_pregunta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;