package com.stackroute.test.util;

public class TestUser {
    private String id;
    private String password;

    private Role role;

    public TestUser(String id, String password, Role role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;}

}