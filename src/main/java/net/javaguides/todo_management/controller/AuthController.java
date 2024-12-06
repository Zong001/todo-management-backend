package net.javaguides.todo_management.controller;

import lombok.AllArgsConstructor;
import net.javaguides.todo_management.dto.RegisterDto;
import net.javaguides.todo_management.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    //Build Register REST API
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
