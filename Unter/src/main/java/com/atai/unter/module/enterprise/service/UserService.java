package com.atai.unter.module.enterprise.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.enterprise.dao.UserDao;
import com.atai.unter.module.enterprise.model.User;

public interface UserService {

	void setUserDao(UserDao userDao);

	void addService(User user);

	void updateUser(User user);

	List<User> listUsers();

	User getUserById(int userId);

	void removeUser(int userid);

}