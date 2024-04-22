package com.example.springbatch3;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class SpringBatch3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatch3Application.class, args);
	}

}
