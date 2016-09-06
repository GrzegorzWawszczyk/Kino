package org.zut.pbai.helpers;

import javax.ejb.Stateless;

/**
 * Created by Vadim on 2016-09-04.
 */
public class LoginBean {

    private String email, password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
