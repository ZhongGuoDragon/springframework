package com.tom.spitter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {
    @Autowired
    private final userList list;

    public UserService() {
        this.list = null;
    }

    public UserService(userList list) {
        this.list = list;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInformation un = list.findByname(username);
        if (un != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(un.getUsername(), un.getPassword(), authorities);
        }
        throw new UsernameNotFoundException(username + "Not Found");
    }
}
