package com.allen.elastic.configurer;

import java.util.Properties;

import org.springframework.core.env.PropertySource;

public class PropertiesResource extends PropertySource<Properties> {
	
	private Properties properties;

	public PropertiesResource(String name, Properties properties) {
		super(name, properties);
		this.properties = properties;
	}

	@Override
	public Object getProperty(String name) {
		return properties.get(name);
	}

}
