package edu.ucsb.cs56.ucsb_courses_search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "edu.ucsb.cs56.ucsb_courses_search" })
@EnableJpaRepositories(basePackages = "edu.ucsb.cs56.ucsb_courses_search.repositories")
@EnableTransactionManagement
@EntityScan(basePackages = "edu.ucsb.cs56.ucsb_courses_search.entities")
public class Application extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .antMatchers("/login**","/webjars/**","/error**")
            .permitAll()
        .anyRequest()
            .authenticated()
        .and()
            .oauth2Login().loginPage("/login")
        .and()
            .logout()
            .deleteCookies("remove")
            .invalidateHttpSession(true)
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .permitAll();
    }
}
