//package org.example.massage.config.auth;
//
//import lombok.RequiredArgsConstructor;
//import org.example.massage.domain.Role;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@RequiredArgsConstructor
//@EnableWebSecurity
//public class SecurityConfig {
//    private final CustomOAuth2UserService customOauth2UserService;
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().headers().frameOptions().disable()
//                .and()
//                    .authorizeRequests()
//                    .antMatchers("/",
//                            "/css/**", "/images/**", "/js/**", "/h2-consle/**",
//                            "/test")
//                    .permitAll()
//                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
//                    .anyRequest().authenticated()
//                .and()
//                    .logout().logoutSuccessUrl("/")
//                .and()
//                    .oauth2Login().userInfoEndpoint().userService(customOauth2UserService);
//    }
//}
