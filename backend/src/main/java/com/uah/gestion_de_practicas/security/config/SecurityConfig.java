package com.uah.gestion_de_practicas.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.uah.gestion_de_practicas.security.jwt.JwtAuthEntryPoint;
import com.uah.gestion_de_practicas.security.jwt.JwtRequestFilter;
import com.uah.gestion_de_practicas.service.UserService;

/**
 * Configuration class for Spring Security
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
        // -- swagger ui
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui/indext.html",
        "/swagger-ui/**",
        "/webjars/**",

        // -- auth 
        "/api/users/login",

        // -- error
        "/error/**"
    };

    private static final String[] STUDENT_WHITELIST = {
        "/api/users/students/**",
        "/api/company/**",
        "/api/practice/**",
        "/api/users/**"
    };

    private static final String[] TUTOR_WHITELIST = {
        "/api/users/tutors/**",
    };

    private static final String[] ADMIN_WHITELIST = {
        "/api/**",
        "/api/**/**",
    };

    @Autowired
    private UserService userService;

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    // ================ CREACIÓN DE BEANS ======================
    @Bean
    public JwtRequestFilter authenticationJwtTokenFilter() {
        return new JwtRequestFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // DEPRECATED
    // TODO: Change with the BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Cross-Site Request Forgery CSRF
        // CORS (Cross-origin resource sharing)
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and() // Exception Handler
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // Not creating sessions, only using tokens
                .authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll() // Allow access to swagger and login endpoints
                .antMatchers(STUDENT_WHITELIST).access("hasAnyRole('ROLE_STUDENT','ROLE_TUTOR','ROLE_SUPERVISOR')") // Restrict the access to the student endpoints
                .antMatchers(TUTOR_WHITELIST).access("hasAnyRole('ROLE_TUTOR','ROLE_SUPERVISOR')") // Restrict the access to the tutor endpoints
                .antMatchers(ADMIN_WHITELIST).access("hasRole('ROLE_SUPERVISOR')") // Restrict the access to the admin endpoints
                .anyRequest().authenticated(); // Restrict the access to any other request
        

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}

