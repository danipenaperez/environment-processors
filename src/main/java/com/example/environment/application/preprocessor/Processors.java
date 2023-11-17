package com.example.environment.application.preprocessor;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.example.environment.application.configuration.TestingConfigurationProperties;

import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;

@Configuration
public class Processors implements BeanDefinitionRegistryPostProcessor, BeanPostProcessor , EnvironmentAware {
	private Environment environment;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment=environment; 
		System.out.println("First thing happend is receive environment (aware)");
		
	}
	
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("Secod thing happend is manage bean context registration (Bean definition class for each one, not beans instantiated");
		
		
	}
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("Secod thing happend is manage bean loading, you can specified how beans must be instantiated");
		var tc = Binder.get(environment).bind("app.testing", TestingConfigurationProperties.class).get();
		System.out.println("car: " + tc.getCar() );
		System.out.println("Drivers: " + tc.getDrivers() );
		System.out.println("Sponsors: " + tc.getSponsors());
		//At this poing TestingConfigurationProperties is no loaded as bean, we can register manually:
		
		beanFactory.registerSingleton("raceCarProperties", tc);
		
		
		
		
		
		///////////////////////////////////
		//ANOTHER WAY TO READ A EXTERNAL YAML FILE USING BINDER ( No needed thirdparty dependencies)
		//////////////////////////////////
		YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
	    factoryBean.setResources(new ClassPathResource("external-config.yaml"));

	    Properties properties = factoryBean.getObject();

	    ConfigurationPropertySource propertySource = new MapConfigurationPropertySource(properties);
	    Binder binder = new Binder(propertySource);

	    var tcManually =  binder.bind("app.testing", TestingConfigurationProperties.class).get(); 
	    System.out.println("car: " + tcManually.getCar() );
		System.out.println("Drivers: " + tcManually.getDrivers() );
		System.out.println("Sponsors: " + tcManually.getSponsors());
	}








}
