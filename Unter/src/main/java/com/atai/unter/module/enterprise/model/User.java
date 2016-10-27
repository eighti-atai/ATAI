package com.atai.unter.module.enterprise.model;

import javax.persistence.*;

//import org.hibernate.mapping.List;

import java.util.Set;
import java.util.List;

@Entity
@Table(name = "user_tab")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
	@Column(name = "user_name")
    private String userName;
	@Column(name = "password")
    private String password;
	@Transient
    private String passwordConfirm;
	@ManyToMany
    @JoinTable(name = "user_role_tab", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> userRoles;
   
    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    
    public List<Role> getRoles() {
        return userRoles;
    }

    public void setRoles(List<Role> roles) {
        this.userRoles = roles;
    }
}
