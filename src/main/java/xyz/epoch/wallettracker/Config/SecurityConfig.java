package xyz.epoch.wallettracker.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource ;

    @Autowired
    private AuthenticationProvider customAuthenticationProvider;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {

        auth.authenticationProvider(customAuthenticationProvider);
    }

    protected  void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                antMatchers("/login, /signup").permitAll().
                antMatchers("/dashboard/**").authenticated().
                and().
                formLogin().loginPage("/login").loginProcessingUrl("/login-process").usernameParameter("email").
                and().
                logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }



}
