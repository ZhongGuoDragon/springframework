package com.tom.spitter.config;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class userList {

    private List<UserInformation> list;
    {
        list = new ArrayList<UserInformation>();
        list.add(new UserInformation("user", "password"));
        list.add(new UserInformation("user1", "password1"));
    }

    public UserInformation findByname(String string) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername() == string) {
                return list.get(i);
            }
        }
        return null;
    }
}

class UserInformation {
    private String username;
    private String password;

    public UserInformation(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
