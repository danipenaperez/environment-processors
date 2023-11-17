package com.example.environment.application.service;

import com.example.environment.application.configuration.TestingConfigurationProperties;

public class RaceCarService {

	private TestingConfigurationProperties raceCarProperties;
	
	public RaceCarService (TestingConfigurationProperties raceCarProperties) {
		this.raceCarProperties = raceCarProperties;
	}
	
	@Override
	public String toString() {
		return "RaceCarService "+ super.toString()+ " with info "+ this.raceCarProperties; 
	}
}
