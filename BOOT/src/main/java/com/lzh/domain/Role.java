package com.lzh.domain;

import java.util.Set;

public class Role {

    private String rid;
    private String name;
    private Set<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "rid='" + rid + '\'' +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
