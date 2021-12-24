package com.example.newadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {
    @GetMapping("/merhaba")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Yeni Sayfa");
    }
}
