package com.javamentor.sbclientapp.model;

import java.io.Serializable;

public class Role implements Serializable {

    private int id;

    private String name;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof com.javamentor.sbclientapp.model.Role)) {
            return false;
        }
        return this.id == ((com.javamentor.sbclientapp.model.Role) o).getId();
    }

    @Override
    public int hashCode() {
        return new Integer(id).hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

}
