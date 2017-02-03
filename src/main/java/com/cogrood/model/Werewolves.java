package com.cogrood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Werewolves {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private Object[] roles;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Object[] getRoles() {
        return roles;
    }

    public void setRoles(Object[] roles) {
        this.roles = roles;
    }
}
