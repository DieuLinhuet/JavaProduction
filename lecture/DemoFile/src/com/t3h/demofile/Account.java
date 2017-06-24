package com.t3h.demofile;

import java.io.Serializable;

/**
 * Created by ducnd on 15/03/2017.
 */
public class Account implements Serializable{
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return username + "\t" + password;
    }
}
