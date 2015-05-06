package com.shopsmart.common.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopsmart.common.domain.UserEntity;
import com.shopsmart.common.exception.dao.UserDAOException;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public UserEntity fetchUser(int userId) throws UserDAOException {
		Session cSession = sf.getCurrentSession();
		UserEntity userEntity = null;
		try {
			Criteria userCriteria = cSession.createCriteria(UserEntity.class).add(Restrictions.eq("userId", userId));
			userEntity = (UserEntity) userCriteria.uniqueResult();
			
		} catch (Exception e) {
			throw new UserDAOException(String.format("Unable to fetch user for user id %d ", userId), e);
		}

		return userEntity;
	}
}
