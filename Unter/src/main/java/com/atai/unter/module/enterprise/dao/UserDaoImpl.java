package com.atai.unter.module.enterprise.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.enterprise.model.Address;
import com.atai.unter.module.enterprise.model.User;

@Repository
public class UserDaoImpl implements UserDao {

private SessionFactory sessionFactory;
	
	
	
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#addAddress(com.atai.unter.module.enterprise.model.Address)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#addUser(com.atai.unter.module.enterprise.model.User)
	 */
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#updateAddress(com.atai.unter.module.enterprise.model.Address)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#updateUser(com.atai.unter.module.enterprise.model.User)
	 */
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);

	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#listUsers()
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#listUsers()
	 */
	public List<User> listUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from User").list();
		return users;
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#getAddressById(int)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#getAddressById(int)
	 */
	public User getUserById(int userId) {
		Session session  = sessionFactory.getCurrentSession();
		User user = session.load(User.class, new Integer(userId));
		return user;
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#removeAddress(int)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#removeAddress(int)
	 */
	public void removeUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.load(User.class, new Integer(userId));
		if (user != null)
		{
			session.delete(user);
		}
	}

}
