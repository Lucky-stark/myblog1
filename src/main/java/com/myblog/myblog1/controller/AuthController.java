package com.myblog.myblog1.controller;

import com.myblog.myblog1.entity.Role;
import com.myblog.myblog1.entity.User;
import com.myblog.myblog1.payload.LoginDto;
import com.myblog.myblog1.payload.SighUpDto;
import com.myblog.myblog1.repository.RoleRepository;
import com.myblog.myblog1.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository){
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("User Signed-in successfully!.", HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SighUpDto sighUpDto){
        if (userRepository.existsByUsername(sighUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(sighUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(sighUpDto.getName());
        user.setUsername(sighUpDto.getUsername());
        user.setEmail(sighUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(sighUpDto.getPassword()));
      //Role roles = roleRepository.findByName("ROLE_ADMIN").get(); // there is a another way we can pass role directly from JSON
        Role roles = roleRepository.findByName(sighUpDto.getRoleType()).get();

        Set<Role> convertRoleToSet = new HashSet<>();//Converted to set for 3rd table user role
        convertRoleToSet.add(roles);
        
        user.setRoles(convertRoleToSet);

        userRepository.save(user);

        return new ResponseEntity<>("User registration successfully", HttpStatus.OK);

    }
}
