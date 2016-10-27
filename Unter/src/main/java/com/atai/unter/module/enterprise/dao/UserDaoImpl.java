package com.atai.unter.module.enterprise.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.enterprise.model.Address;
import com.atai.unter.module.enterprise.model.User;

@Repository
public class UserDaoImpl implements UserDao {

private SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
	}


	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);

	}

	
	public List<User> listUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from User").list();
		return users;
	}


	public User getUserById(int userId) {
		Session session  = sessionFactory.getCurrentSession();
		User user = session.load(User.class, new Integer(userId));
		return user;
	}

	public User findByUsername(String username) {
		Session session  = sessionFactory.getCurrentSession();
		User user = session.load(User.class, username);
		return user;
	}
	
	public void removeUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.load(User.class, new Integer(userId));
		if (user != null)
		{
			session.delete(user);
		}
	}

}
