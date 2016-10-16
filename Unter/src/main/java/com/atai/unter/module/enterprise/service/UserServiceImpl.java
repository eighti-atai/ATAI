package com.atai.unter.module.enterprise.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atai.unter.module.enterprise.dao.UserDao;
import com.atai.unter.module.enterprise.model.User;
@Service
public class UserServiceImpl implements UserService {

private UserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.service.UserService#setUserDao(com.atai.unter.module.enterprise.dao.UserDao)
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.service.UserService#addService(com.atai.unter.module.enterprise.model.User)
	 */
	@Transactional
	public void addService(User user) {
		userDao.addUser(user);

	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.service.UserService#updateUser(com.atai.unter.module.enterprise.model.User)
	 */
	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.service.UserService#listUsers()
	 */
	@Transactional(readOnly = true)
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.service.UserService#getUserById(int)
	 */
	@Transactional(readOnly = true)
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.service.UserService#removeUser(int)
	 */
	@Transactional
	public void removeUser(int userid) {
		userDao.removeUser(userid);

	}
	
}
