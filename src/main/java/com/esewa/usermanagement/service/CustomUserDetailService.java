package com.esewa.usermanagement.service;

import com.esewa.usermanagement.constants.Exceptions;
import com.esewa.usermanagement.exceptions.UserNotFoundException;
import com.esewa.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        return userRepository.findByName(username)
                .map(CustomUserDetail::new)
                .orElseThrow(UserNotFoundException::new);
    }
}
