package com.shopsmart.common.test.dao;

import java.sql.Statement;

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

import com.shopsmart.common.dao.UserDAO;
import com.shopsmart.common.domain.UserEntity;
import com.shopsmart.common.exception.dao.UserDAOException;
import com.shopsmart.common.test.config.TestConfig;
import com.shopsmart.common.test.datasetup.QueryStore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("dev")
@Transactional
public class UserDAOTest {

	static final Logger logger = Logger.getLogger(UserDAOTest.class);

	@Autowired
	private QueryStore store;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDAO userDAO;

	@Before
	public void setup() {
		BasicConfigurator.configure();

		String insertUserQuery = store.insertUserQuery();
		try {
			Statement statement = dataSource.getConnection().createStatement();
			statement.execute(insertUserQuery);
		} catch (Exception e) {
			logger.error("Exception occurred in the setup method", e);
			Assert.fail();

		}
	}

	@Test
	public void fetchUser() {
		try {
			UserEntity user = userDAO.fetchUser(1);
			Assert.assertNotNull(user);
			Assert.assertEquals(0, user.getUpdatedBy());
			Assert.assertEquals(1, user.getUserId());
			Assert.assertEquals("USER1PASSWORD", user.getCurrentPassword());
			Assert.assertEquals("2015-05-07 12:51:35.0", String.valueOf(user.getDateCreated()));
			Assert.assertEquals("2015-05-07 12:51:35.0", String.valueOf(user.getDateUpdated()));
			Assert.assertEquals("USER1", user.getLoginEmail());
			Assert.assertEquals("USER1", user.getUserName());
		} catch (UserDAOException e) {
			logger.error("Exception occurred in the fetchUser method", e);
			Assert.fail();
		}
	}
}
