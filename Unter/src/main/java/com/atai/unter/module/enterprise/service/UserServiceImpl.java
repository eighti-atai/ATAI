package com.atai.unter.module.enterprise.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.atai.unter.module.enterprise.dao.RoleDao;
import com.atai.unter.module.enterprise.dao.UserDao;
import com.atai.unter.module.enterprise.model.User;


import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    /* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.service.UserService#save(com.atai.unter.module.enterprise.model.User)
	 */
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleDao.listRoles());
        userDao.addUser(user);
    }

    /* (non-Javadoc)
	 * @see com.atai.unter.module.enterprise.service.UserService#findByUsername(java.lang.String)
	 */
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}