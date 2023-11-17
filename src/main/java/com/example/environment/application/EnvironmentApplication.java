package com.example.environment.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.environment.application.configuration.TestingConfigurationProperties;
import com.example.environment.application.preprocessor.Processors;
import com.example.environment.application.service.RaceCarService;

@SpringBootApplication
@Import(Processors.class)  //Needed to Processors Preprocessing invocation.
public class EnvironmentApplication {

	public static void main(String[] args) {
		var applicationContext = SpringApplication.run(EnvironmentApplication.class, args);
		TestingConfigurationProperties properties = (TestingConfigurationProperties) applicationContext.getBean("raceCarProperties");
		System.out.println("found manually Registered bean :"+ properties);
		
		RaceCarService raceCar = (RaceCarService) applicationContext.getBean("raceCarService");
		System.out.println("found auto Created in configuration but with injected manually bean :"+ raceCar );
	}
	
	
	
	@Configuration
    public static class RaceEventApplicationConfig {
        @Bean
        RaceCarService raceCarService (TestingConfigurationProperties raceCarProperties) { //RaceCarProperties is manually injected on processors
        	//Receive raceCarProperties Manually injected in Processors
            return new RaceCarService(raceCarProperties);
        }
    }

}
