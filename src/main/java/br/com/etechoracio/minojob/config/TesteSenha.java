package br.com.etechoracio.minojob.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteSenha {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder(12).encode("senha"));
    }
    
}