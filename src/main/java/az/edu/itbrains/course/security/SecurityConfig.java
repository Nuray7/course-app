package az.edu.itbrains.course.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService userDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(x -> x.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers(
                                "/register",
                                "/login",
                                "/forgot-password",
                                "/change-password",
                                "/css/**",
                                "/js/**",
                                "/images/**"
                        ).permitAll()
                        .requestMatchers("/contact").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                )
                .exceptionHandling(e -> e.accessDeniedPage("/"));

        return http.build();
    }
}