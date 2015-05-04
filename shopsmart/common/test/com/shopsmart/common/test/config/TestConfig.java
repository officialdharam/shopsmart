package com.shopsmart.common.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Profile("dev")
@PropertySource({ "classpath:shopsmart-test.properties" })
@ComponentScan(basePackages = { "com.shopsmart.common.test", "com.shopsmart.common.config" })
public class TestConfig {
	
	@Bean(name = "appProperty")
	public static PropertySourcesPlaceholderConfigurer appProperty() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
