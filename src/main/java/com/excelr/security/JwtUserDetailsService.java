package com.excelr.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excelr.model.Login;
import com.excelr.model.Register;
import com.excelr.repo.LoginRepo;
import com.excelr.repo.RegisterRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepo loginRepo;
    
    @Autowired
    private RegisterRepo registerRepo;

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Login login = loginRepo.findByEmail(email);
//        if (login == null) {
//            throw new UsernameNotFoundException("User not found with username: " + email);
//        }
//
//        // Convert the user's role to a GrantedAuthority
//        return new org.springframework.security.core.userdetails.User(
//                login.getEmail(),
//                login.getPassword(),
//                List.of(new SimpleGrantedAuthority(login.getRole().getName().name())) // Single role
//        );
//    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Register register = registerRepo.findByEmail(email);
        if (register == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                register.getEmail(),
                register.getPassword(),
                new ArrayList<>()
        );
    }
}
