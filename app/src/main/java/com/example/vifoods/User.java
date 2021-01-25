package com.example.vifoods;

import java.io.Serializable;

/**
 * Данные о пользователе
 * @author Vitaly Melnichenko
 * @version 1.0
 */
public class User implements Serializable {
    private String mLogin;
    private String mPassword;

    public User(String login, String password) {
        mLogin = login;
        mPassword = password;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
