package com.mt.temperature.temperatureapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Predicates;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages={"com.mt.temperature"})
public class TemperatureApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureApiApplication.class, args);
	}
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).select()
	.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
	}

}
