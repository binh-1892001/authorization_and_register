package com.ra.controller;

import com.ra.exception.CustomException;
import com.ra.model.dto.FormRegister;
import com.ra.model.dto.UserLoginRequestDTO;
import com.ra.model.dto.UserLoginResponseDTO;
import com.ra.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO) throws CustomException
    {

        return new ResponseEntity<>(authService.login(userLoginRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody FormRegister formRegister) {
        authService.register(formRegister);
        return new ResponseEntity<>("Register successfully !!!",HttpStatus.CREATED);
    }

}
