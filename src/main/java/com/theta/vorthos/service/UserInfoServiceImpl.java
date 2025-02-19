package com.theta.vorthos.service;

import com.theta.vorthos.dto.LoginDto;
import com.theta.vorthos.dto.UserDto;
import com.theta.vorthos.dto.UserInfoDto;
import com.theta.vorthos.mapper.DtoToEntity;
import com.theta.vorthos.mapper.EntityToDto;
import com.theta.vorthos.repository.UserInfoRepository;
import com.theta.vorthos.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean signup(UserDto userDto) {
        try{
            userInfoRepository.save(dtoToEntity.toUserInfo(userDto));
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public ResponseEntity<String> login(LoginDto loginDto) {
        String pass = Objects.requireNonNull(userInfoRepository.findByEmail(loginDto.email()).orElse(null)).getPassword();
        boolean isMatch = passwordEncoder.matches(loginDto.password(),pass);
        log.info("isMatch: " + isMatch);
        try{
             Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.email(),loginDto.password()));
//            UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.email());
            return ResponseEntity.status(HttpStatus.OK).body(jwtUtil.generateToken(authentication.getName()));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public List<UserInfoDto> getUsers() {
        return entityToDto.toUserDto(userInfoRepository.findAll());
    }

    @Override
    public boolean writeArticle(String article) {
        return false;
    }

    @Override
    public boolean editArticle(String article) {
        return false;
    }
}
