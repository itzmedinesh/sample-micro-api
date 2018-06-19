package com.itzmeds.testapp;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class TestConfigInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ObjectMapper yamlParser = new ObjectMapper(new YAMLFactory());

		TestConfiguration appConfig = null;
		try {

			appConfig = yamlParser.readValue(new File("test.yml"), TestConfiguration.class);

			GenericApplicationContext parent = new StaticApplicationContext();
			parent.getBeanFactory().registerSingleton("configuration", appConfig);
			parent.refresh();

			applicationContext.setParent(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}