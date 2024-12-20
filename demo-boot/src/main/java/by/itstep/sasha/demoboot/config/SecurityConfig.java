package by.itstep.sasha.demoboot.config;

import by.itstep.sasha.demoboot.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth ->
                auth.requestMatchers("/register").permitAll()
                        .requestMatchers("users").permitAll().requestMatchers("home-page")
                        .permitAll().requestMatchers("forgot-password").permitAll()
                        .requestMatchers("address").permitAll()
                        .requestMatchers("car").permitAll()
                        .requestMatchers("announcement").permitAll()
                        .requestMatchers("site").permitAll()

                        .requestMatchers("users").permitAll()
                        .requestMatchers("delete-user-{email}").permitAll()
                        .requestMatchers("update-user-{email}").permitAll()

                        .requestMatchers("/css/**").permitAll().requestMatchers("/js/**").permitAll().requestMatchers("/img/**").permitAll());

        // LOGIN
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/home-page", true)
                        .permitAll());
        // LOGOUT
        http.logout(logout ->
                logout.invalidateHttpSession(true).clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll());
        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
