package com.netcracker.theater.rtickets.security;

import com.netcracker.theater.rtickets.data.core.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests().antMatchers("/", "/login", "/logout", "/mainPage", "/error", "/error-404", "/error-500").permitAll();


        http.authorizeRequests().antMatchers("/userPage").access("hasRole('ROLE_USER')");
        http.authorizeRequests().antMatchers("/adminPage", "/status").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/allPage","/recommendation").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')");
        http.authorizeRequests().antMatchers("/registration").not().fullyAuthenticated();


        http.authorizeRequests()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/mainPage") .permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }
}