package com.atai.unter.module.enterprise.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.atai.unter.module.enterprise.model.User;

public interface UserDao {

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	void setSessionFactory(SessionFactory sessionFactory);

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#addAddress(com.atai.unter.module.enterprise.model.Address)
	 */
	void addUser(User user);

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#updateAddress(com.atai.unter.module.enterprise.model.Address)
	 */
	void updateUser(User user);

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#listUsers()
	 */
	List<User> listUsers();

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#getAddressById(int)
	 */
	User getUserById(int userId);

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#removeAddress(int)
	 */
	void removeUser(int userId);

}