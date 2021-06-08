package com.chnu.pavel.telephone.security;

import com.chnu.pavel.telephone.repository.user.UserRepository;
import com.chnu.pavel.telephone.security.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.WebSecurityConfig
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 05.06.2021|19:16
 * @Version WebSecurityConfig: 1.0
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/js/**", "/css/**", "/img/**").permitAll()
            .antMatchers("/dashboard").hasAnyAuthority("USER", "ADMIN", "SUPER_ADMIN")
            .antMatchers("/provinces/**").hasAnyAuthority("ADMIN", "SUPER_ADMIN")
            .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
            .and()
                .logout()
                .clearAuthentication(true)
                .logoutSuccessUrl("/login?out")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }
}
