package com.albin.universitySystem.Services;

import com.albin.universitySystem.entities.Authority;
import com.albin.universitySystem.entities.Profesor;
import com.albin.universitySystem.Repositories.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService{
    private final ProfesorRepository profesorRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profesor profesor = profesorRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Profesor Not Found"));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+profesor.getRole().getName()));
        profesor.getAuthorities()
                .stream()
                .map(Authority::getAuthority)
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .forEach(authorities::add);

        return new User(profesor.getEmail(), profesor.getPassword(),  authorities);
    }
}
