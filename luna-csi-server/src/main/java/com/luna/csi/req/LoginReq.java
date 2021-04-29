package com.luna.csi.req;

import javax.validation.constraints.NotNull;

/**
 * @author luna@mac
 * 2021年04月29日 10:00
 */
public class LoginReq {

    @NotNull
    private String username;

    private String password;

    private String readMe;

    public String getReadMe() {
        return readMe;
    }

    public void setReadMe(String readMe) {
        this.readMe = readMe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
