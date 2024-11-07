package com.ra.controller;

import com.ra.exception.CustomException;
import com.ra.model.dto.ChangePassword;
import com.ra.security.UserPrinciple;
import com.ra.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class HomeController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public ResponseEntity<?> home(){
        return new ResponseEntity<>("Xin chao user", HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> profile()
    {
        UserPrinciple userPrinciple = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return new ResponseEntity<>(userPrinciple.getUser(), HttpStatus.OK);
    }

    // password change { oldPassword, newPassword, confirmPassword }
    @PutMapping("/password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePassword changePassword) throws CustomException
    {
        authService.handleChangePassword(changePassword);
        return new ResponseEntity<>("Change password successfully !!!", HttpStatus.OK);
    }

}
