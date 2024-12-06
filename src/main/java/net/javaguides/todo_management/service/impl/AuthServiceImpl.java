package net.javaguides.todo_management.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.todo_management.dto.RegisterDto;
import net.javaguides.todo_management.entity.Role;
import net.javaguides.todo_management.entity.User;
import net.javaguides.todo_management.exception.TodoAPIException;
import net.javaguides.todo_management.repository.RoleRepository;
import net.javaguides.todo_management.repository.UserRepository;
import net.javaguides.todo_management.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public String register(RegisterDto registerDto) {
        // check username is already exists in database
        if (userRepository.existsByUsername(registerDto.getUsername())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Username already exists!");
        }
        if (userRepository.existsByEmail(registerDto.getEmail())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Email already exists!");

        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        return "User Registered Successfully!";
    }
}
