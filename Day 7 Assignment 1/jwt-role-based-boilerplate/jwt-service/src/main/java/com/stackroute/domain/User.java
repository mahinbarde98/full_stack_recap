package com.stackroute.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * to define an entity
 */
@Entity
@Table(name = "User")
public class User {

    /**
     * @Id annotation to make id variable as Primary key
     */
    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name= "role")
    private Role role;


    /**
     * default constructor
     */
    public User() {
        super();
    }

    /**
     * parameterized constructor
     */
    public User(String id, String password,Role role) {
        super();
        this.id = id;
        this.password = password;
        this.role = role;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
