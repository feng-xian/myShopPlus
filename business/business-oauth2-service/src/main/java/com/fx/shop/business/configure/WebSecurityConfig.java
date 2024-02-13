package com.fx.shop.business.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;



/**
 * 安全服务器
 */
@Configuration
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    /**
     * 主要进行用户身份验证
     * @return
     */
//    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User
                .builder()
                .username("user")
                .password(passwordEncoder().encode("123456"))
                .roles("ROLE")
                .build();

        UserDetails user2 = User
                .builder()
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ROLE")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }


    /**
     * Spring Security的过滤器链，用于Spring Security的身份认证
     * @param http
     * @return
     * @throws Exception
     */
//    @Bean
//    @Order(2)
    public SecurityFilterChain defaultSecurityFilterChain2(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/actuator/**"),
                                new AntPathRequestMatcher("/oauth2/**"),
                                new AntPathRequestMatcher("/**/*.json"),
                                new AntPathRequestMatcher("/**/*.html")).permitAll()
                        .anyRequest().authenticated()
                )
                .cors(Customizer.withDefaults())
                .csrf((csrf) -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//				// Form login handles the redirect to the login page from the
//				// authorization server filter chain
                .formLogin(Customizer.withDefaults())
        ;

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/actuator/**"),
                                new AntPathRequestMatcher("/oauth2/**"),
                                new AntPathRequestMatcher("/**/*.json"),
                                new AntPathRequestMatcher("/client/**/**"),
                                new AntPathRequestMatcher("/**/*.html")).permitAll()
                        .anyRequest().authenticated()
                )
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
//                .httpBasic(Customizer.withDefaults())
//				// Form login handles the redirect to the login page from the
//				// authorization server filter chain
                .formLogin(Customizer.withDefaults())
//                .oauth2Login((login) -> {
//                    login.failureHandler(new Oauth2FailureHandler());
//                })
//                .formLogin(v -> v.loginPage(""))
        ;

        return http.build();
    }


}
