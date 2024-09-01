package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

// Question 4
@Service
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminService {

    public void method1() {
        // method logic
    }

    public void method2() {
        // method logic
    }

    public void method3() {
        // method logic
    }
}