package com.shopsmart.common.test.context;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.shopsmart.common.test.config.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("dev")
@Transactional
public class AppContextTest {

	static final Logger logger = Logger.getLogger(AppContextTest.class);

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		BasicConfigurator.configure();
	}

	@Test
	public void dataSourceBean() {
		Assert.assertNotNull(dataSource);
	}
}
