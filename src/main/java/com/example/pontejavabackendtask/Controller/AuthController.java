package com.example.pontejavabackendtask.Controller;

import com.example.pontejavabackendtask.Entity.UserEntity;
import com.example.pontejavabackendtask.Service.JWTService;
import com.example.pontejavabackendtask.Service.UserService;
import com.example.pontejavabackendtask.dto.LoginResponseDto;
import com.example.pontejavabackendtask.dto.LoginUserDto;
import com.example.pontejavabackendtask.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthController {

    private final UserService userService;
    private final JWTService jwtService;

    @Autowired
    public AuthController(UserService userService, JWTService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterUserDto registerUserDto) {
        userService.register(registerUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserEntity authenticatedUser = userService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
