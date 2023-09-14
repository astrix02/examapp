package com.exam;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.controller.ExamController;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private ExamController examController;

	@Test
	void contextLoads() {
		assertThat(examController).isNotNull();
	}

}
