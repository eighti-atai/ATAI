package com.atai.unter.module.enterprise.model;

import java.util.Set;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.atai.unter.module.enterprise.model.User;

@Entity
@Table(name = "role_tab")
public class Role {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String roleId;
	
	@Column(name = "role_name")
	private String name;
	@ManyToMany(mappedBy = "userRoles")
	private List<User> users;

    public String getId() {
        return roleId;
    }

    public void setId(String id) {
        this.roleId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
	
}
