package com.theta.vorthos.service;

import com.theta.vorthos.model.UserInfo;
import com.theta.vorthos.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserInfoRepository userInfoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<UserInfo> userInfo = userInfoRepository.findByEmail(email);
        if (userInfo.isPresent()) {
            UserInfo user = userInfo.get();
            return User.builder()
                    .username(email)
                    .password(user.getPassword())
                    .roles(String.valueOf(user.getRoles())).
                    build();
        }
        else throw new UsernameNotFoundException(username);
    }
}
