package com.shopsmart.common.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({ HibernateConfig.class })
@Profile("dev")
@PropertySource({ "classpath:shopsmart-test.properties" })
@ComponentScan(basePackages = "com.shopsmart.common", excludeFilters = { @ComponentScan.Filter(Configuration.class) })
public class TestConfig {

}
