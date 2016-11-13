package com.atai.unter.module.enterprise.dao;

import com.atai.unter.module.enterprise.model.User;

public interface UserDao {

	void addUser(User user);

	User findByUserId(int userId);

	User findByUserName(String userName);

}