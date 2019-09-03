package com.meli.tracing.security;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class TracingSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}test").roles("ADMIN");
    }
    
    @Bean
    public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	String[] resources = new String[]{"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"};

    	http
        .authorizeRequests()
        .antMatchers(resources).permitAll()  
        .antMatchers("/","/index").permitAll()
        .antMatchers(HttpMethod.GET, "/process/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/nearest").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/furthest").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/average").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/main")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout()
            .permitAll()
            .logoutSuccessUrl("/")
            .and().sessionManagement()
            .invalidSessionUrl("/").maximumSessions(1)
            .maxSessionsPreventsLogin(true).expiredUrl("/");
    }

}
