package com.shopsmart.common.dao;

import com.shopsmart.common.domain.UserEntity;
import com.shopsmart.common.exception.dao.UserDAOException;

public interface UserDAO {

	public UserEntity fetchUser(int userId) throws UserDAOException;
}
