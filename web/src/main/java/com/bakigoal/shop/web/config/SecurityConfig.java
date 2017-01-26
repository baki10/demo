package com.bakigoal.shop.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.bakigoal.shop.server.config")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  public static final String DEF_USERS_BY_USERNAME_QUERY =
      "select username,password,enabled " +
          "from users " +
          "where username = ?";
  public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
      "select username,authority " +
          "from users " +
          "where username = ?";

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("user").password("password").roles("USER").and()
        .withUser("admin").password("password").roles("USER", "ADMIN");

//    auth.jdbcAuthentication().dataSource(dataSource)
//        .usersByUsernameQuery(DEF_USERS_BY_USERNAME_QUERY)
//        .authoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY)
//        .passwordEncoder(new StandardPasswordEncoder("53cr3tkey"));
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests()
//        .anyRequest().authenticated() //all requests will checked
//        .and()
//        .formLogin()
//        .and()
//        .httpBasic();

    http
        .authorizeRequests()
        .antMatchers("/home").authenticated()
        .antMatchers(HttpMethod.POST, "/product").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin()
        .and()
        .httpBasic();


//        .formLogin().loginPage("/login.html").permitAll().usernameParameter("j_username")
//        .passwordParameter("j_password").loginProcessingUrl("/j_spring_security_check").failureUrl("/login.html?error=true")
//        .and()
//        .httpBasic()
//        .and()
//        .authorizeRequests().antMatchers("/security/**").hasRole("ADMIN")
//        .antMatchers("/user/**").hasRole("USER")
//        .and()
//        .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/")
//        .and()
//        .rememberMe().key("myKey").tokenValiditySeconds(300)
//        .and()
//        .csrf().disable();
  }
}
