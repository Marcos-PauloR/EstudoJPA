package com.cursojpa.cursojpa.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cursojpa.cursojpa.dto.EmailDTO;
import com.cursojpa.cursojpa.security.JWTUtil;
import com.cursojpa.cursojpa.security.UserSS;
import com.cursojpa.cursojpa.service.AuthService;
import com.cursojpa.cursojpa.service.UserService;


@Controller
@RequestMapping("/auth")
public class AuthResource {
 
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @RequestMapping(value="/refresh_token", method=RequestMethod.GET)
    public ResponseEntity<Void> requestMethodName(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer "+token);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(value="/forgot", method=RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO emailDTO) {
        authService.sendNewPassword(emailDTO.getEmail());
        return ResponseEntity.noContent().build();
    }
    


}
