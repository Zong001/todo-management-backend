package net.javaguides.todo_management.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("pass"));
        String hashedPassword = passwordEncoder.encode("zzzz5");
        String ty = "$2a$10$PmVM/9JN1xdyW/HRpYPq0OTISl.xGh7agF.HaZoiBMeftnnNUFUFy";
        System.out.println(ty);
        System.out.println(passwordEncoder.matches("zzzz5",ty));

        System.out.println(hashedPassword);
        System.out.println("$2a$10$PmVM/9JN1xdyW/HRpYPq0OTISl.xGh7agF.HaZoiBMeftnnNUFUFy");
        System.out.println(passwordEncoder.matches("zzzz5",hashedPassword));
    }
}
