package com.theta.vorthos.controller;

import com.theta.vorthos.dto.LoginDto;
import com.theta.vorthos.dto.UserDto;
import com.theta.vorthos.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vorthos/public")
@RequiredArgsConstructor
public class PublicController {
    private final UserInfoService userInfoService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> createUser(@RequestBody UserDto  userDto) {
        return userInfoService.signup(userDto)?ResponseEntity.ok("User Successfully registered!!"):ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return userInfoService.login(loginDto);
    }
    @GetMapping()
    public String welcomePage(){
        return "Welcome to the vorthos!";
    }
}
