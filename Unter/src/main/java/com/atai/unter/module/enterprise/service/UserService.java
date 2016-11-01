package com.atai.unter.module.enterprise.service;

import com.atai.unter.module.enterprise.model.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

}