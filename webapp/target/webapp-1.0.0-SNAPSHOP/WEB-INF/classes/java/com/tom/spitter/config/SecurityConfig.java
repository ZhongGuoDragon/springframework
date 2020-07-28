package com.tom.spitter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER", "ADMIN");
        auth.userDetailsService(new UserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/spittles/find/**").hasRole("ADMIN").anyRequest().permitAll();;
//        http.formLogin().defaultSuccessUrl("/spittles/find/1").and().logout().permitAll();
////        http.csrf().disable();
//        http.requiresChannel().antMatchers("/spittles/form").requiresSecure();

        http.authorizeRequests().antMatchers("/spittles/register").hasRole("ADMIN").anyRequest().permitAll().and().formLogin()
                .defaultSuccessUrl("/spittles/view").and().logout().logoutSuccessUrl("/spittles/find/1").logoutUrl("/spittles/logout").and().csrf().disable();
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();
    }
}
