package com.theta.vorthos.service;

import com.theta.vorthos.enums.Roles;
import com.theta.vorthos.model.UserInfo;
import com.theta.vorthos.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userInfoRepository.findByEmail(username).orElseThrow();
        return User.builder()
                .username(username)
                .password(user.getPassword())
                .roles(
                        user.getRoles().stream().map(Roles::toString)
                        .toArray(String[]::new)
                )
                .build();
    }
}
