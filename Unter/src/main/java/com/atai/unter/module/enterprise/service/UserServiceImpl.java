package com.atai.unter.module.enterprise.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.atai.unter.module.enterprise.dao.UserDao;
import com.atai.unter.module.enterprise.model.User;

public class UserServiceImpl {

private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void addService(User user) {
		userDao.addUser(user);

	}

	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	@Transactional(readOnly = true)
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	@Transactional(readOnly = true)
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Transactional
	public void removeUser(int userid) {
		userDao.removeUser(userid);

	}
	
}
