package com.shopsmart.common.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shopsmart.common.util.Constants;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.shopsmart.common", excludeFilters = { @ComponentScan.Filter(Configuration.class)})
public class HibernateConfig {

	static final Logger logger = Logger.getLogger(HibernateConfig.class);
	
	@Value(Constants.HIBERNATE_DIALECT)
	private String hibernateDialect;

	@Autowired
	private DataSource dataSource;

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() throws Exception {
		logger.info("Creating Session Factory");
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", "false");
		properties.put("current_session_context_class", "thread");
		properties.put("dynamic-update", "true");
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setPackagesToScan(new String[] { Constants.DOMAIN_MODEL_PACKAGE });
		factory.setDataSource(dataSource);
		factory.setHibernateProperties(properties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager() throws Exception {
		return new HibernateTransactionManager(getSessionFactory());
	}
}
