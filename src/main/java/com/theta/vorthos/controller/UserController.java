package com.theta.vorthos.controller;

import com.theta.vorthos.dto.LoginDto;
import com.theta.vorthos.dto.UserDto;
import com.theta.vorthos.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vorthos")
@RequiredArgsConstructor
public class UserController {
    private final UserInfoService userInfoService;

    @PostMapping("/public/sign-up")
    public ResponseEntity<String> createUser(@RequestBody UserDto  userDto) {
        return userInfoService.signup(userDto)?ResponseEntity.ok("User Successfully registered!!"):ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
    }
    @PostMapping("/public/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return userInfoService.login(loginDto);
    }
    @GetMapping()
    public String welcomePage(){
        return "Welcome to the vorthos!";
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authorizedHeader) {
        return userInfoService.logout(authorizedHeader)?ResponseEntity.status(HttpStatus.OK).body("Successfully logged out"):ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token");
    }
}
