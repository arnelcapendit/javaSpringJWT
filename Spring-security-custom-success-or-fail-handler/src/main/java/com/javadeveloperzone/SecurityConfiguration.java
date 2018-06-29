package com.javadeveloperzone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * Created by Java Developer Zone on 15-11-2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired      // here is configuration related to spring boot basic authentication
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("zone").password("mypassword").roles("USER")
            .and()
            .withUser("zone2").password("mypassword").roles("ADMIN");// those are user name and password
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests().antMatchers("/loginFailed").permitAll().and().authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .successHandler(new CustomAuthenticationSuccessHandler())                 // On authentication success custom handler
            .failureHandler(new CustomAuthenticationFailureHandler())                 // on authentication fail custom handler
            .loginPage("/login")
            .permitAll();
    }
}