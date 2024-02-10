package com.myblog.myblog1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Myblog1Application {

	public static void main(String[] args) {
		SpringApplication.run(Myblog1Application.class, args);
	}
	@Bean
	public ModelMapper getmodelMapper(){
		return new ModelMapper();
	}

}
