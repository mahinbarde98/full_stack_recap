package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class)
public class Employee implements Serializable {

    private String id;
    private String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + "]";
    }

}