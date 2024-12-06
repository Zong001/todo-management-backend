package net.javaguides.todo_management.service;

import net.javaguides.todo_management.dto.RegisterDto;

public interface AuthService {
    String register (RegisterDto registerDto);
}
