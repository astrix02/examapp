package com.exam.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testCrearExamen() throws Exception {
		this.mockMvc.perform(post("/crearExamen").contentType(MediaType.APPLICATION_JSON)
				.content("{\n"
						+ "    \"tituloExamen\":\"Historia de Mexico\",\n"
						+ "    \"preguntas\":[\n"
						+ "        {\n"
						+ "            \"pregunta\":\"¿En que años tuvo lugar la guerra de los tres años en México?\",\n"
						+ "            \"respuestas\":[\n"
						+ "                {\n"
						+ "                    \"respuesta\":\"1519 a 1521\",\n"
						+ "                    \"correcta\":false\n"
						+ "                },\n"
						+ "                {\n"
						+ "                    \"respuesta\":\"1810 a 1821\",\n"
						+ "                    \"correcta\":false\n"
						+ "                },\n"
						+ "                {\n"
						+ "                    \"respuesta\":\"1858 a 1861\",\n"
						+ "                    \"correcta\":true\n"
						+ "                },\n"
						+ "                {\n"
						+ "                    \"respuesta\":\"1877 a 1910\",\n"
						+ "                    \"correcta\":false\n"
						+ "                }   \n"
						+ "            ]\n"
						+ "        }\n"
						+ "    ]\n"
						+ "}"))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testCrearEstudiante() throws Exception {
		this.mockMvc.perform(post("/crearEstudiante").contentType(MediaType.APPLICATION_JSON)
				.content("{\n"
						+ "    \"nombre\":\"Abraham Hernandez\",\n"
						+ "    \"edad\":\"30\",\n"
						+ "    \"ciudad\":\"Queretaro\",\n"
						+ "    \"zonaHoraria\":\"America/Los_Angeles\"\n"
						+ "}"))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testGetEstudiantes() throws Exception {
		this.mockMvc.perform(get("/getEstudiantes")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testAsignarExamen() throws Exception {
		this.mockMvc.perform(post("/asignarExamen").contentType(MediaType.APPLICATION_JSON)
				.content("{\n"
						+ "    \"estudianteId\":1,\n"
						+ "    \"examenId\":28,\n"
						+ "    \"fecha\":\"2023-11-20T14:00:00\"\n"
						+ "}"))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testResponderExamen() throws Exception {
		this.mockMvc.perform(post("/responderExamen").contentType(MediaType.APPLICATION_JSON)
				.content("{\n"
						+ "    \"respuestas\": [\n"
						+ "        {\n"
						+ "            \"asignacionId\": 1,\n"
						+ "            \"preguntaId\": 15,\n"
						+ "            \"respuestaPreguntaId\": 3\n"
						+ "        },\n"
						+ "        {\n"
						+ "            \"asignacionId\": 1,\n"
						+ "            \"preguntaId\": 16,\n"
						+ "            \"respuestaPreguntaId\": 6\n"
						+ "        }\n"
						+ "    ]\n"
						+ "}"))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testCalificarExamen() throws Exception {
		this.mockMvc.perform(post("/calificarExamen").contentType(MediaType.APPLICATION_JSON)
				.content("{\n"
						+ "    \"estudianteId\":1,\n"
						+ "    \"asignacionId\":1\n"
						+ "}"))
		.andDo(print()).andExpect(status().isOk());
	}
}
