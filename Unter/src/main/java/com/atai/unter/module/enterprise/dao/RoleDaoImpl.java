package com.atai.unter.module.enterprise.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.enterprise.model.Role;
import com.atai.unter.module.enterprise.model.User;

@Repository
public class RoleDaoImpl implements RoleDao {
	
private SessionFactory sessionFactory;
	
	
	
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.RoleDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#addAddress(com.atai.unter.module.enterprise.model.Address)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#addUser(com.atai.unter.module.enterprise.model.User)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.RoleDao#addRole(com.atai.unter.module.enterprise.model.Role)
	 */
	@Override
	public void addRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(role);
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#updateAddress(com.atai.unter.module.enterprise.model.Address)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#updateUser(com.atai.unter.module.enterprise.model.User)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.RoleDao#updateRole(com.atai.unter.module.enterprise.model.Role)
	 */
	@Override
	public void updateRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.update(role);

	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#listUsers()
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#listUsers()
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.RoleDao#listRoles()
	 */
	@Override
	public List<Role> listRoles() {
		Session session = sessionFactory.getCurrentSession();
		List<Role> roles = session.createQuery("from Role").list();
		return roles;
	}

	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#getAddressById(int)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#getAddressById(int)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.RoleDao#getRoleById(int)
	 */
	@Override
	public Role getRoleById(int roleId) {
		Session session  = sessionFactory.getCurrentSession();
		Role role = session.load(Role.class, new Integer(roleId));
		return role;
	}

	/*public Role findByUsername(String username) {
		Session session  = sessionFactory.getCurrentSession();
		User user = session.load(User.class, username);
		return user;
	}*/
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#removeAddress(int)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.UserDao#removeAddress(int)
	 */
	/* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.dao.RoleDao#removeRole(int)
	 */
	@Override
	public void removeRole(int roleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.load(Role.class, new Integer(roleId));
		if (role != null)
		{
			session.delete(role);
		}
	}

}
