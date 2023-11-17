package com.example.environment.application.configuration;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.example.environment.application.bean.Car;
import com.example.environment.application.bean.Driver;



public class TestingConfigurationProperties {
	//Simple object Mapping
	private Car car;
	//Map of objects
	private Map<String, Driver> drivers;
	//List of objects
	private List<String> sponsors;

	
	
	public List<String> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<String> sponsors) {
		this.sponsors = sponsors;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
		
	public Map<String, Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(Map<String, Driver> drivers) {
		this.drivers = drivers;
	}




	
}
