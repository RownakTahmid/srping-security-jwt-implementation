package com.theta.vorthos.config;

import com.theta.vorthos.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class SecurityConfigAlt {
    private UserDetailsServiceImpl userDetailsService;
    private PasswordEncoder passwordEncoder;
    private void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
