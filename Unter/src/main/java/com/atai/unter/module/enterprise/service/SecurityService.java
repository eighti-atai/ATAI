package com.atai.unter.module.enterprise.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
