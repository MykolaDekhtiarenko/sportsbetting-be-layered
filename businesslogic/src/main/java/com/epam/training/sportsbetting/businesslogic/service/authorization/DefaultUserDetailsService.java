package com.epam.training.sportsbetting.businesslogic.service.authorization;

import com.epam.training.sportsbetting.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private static final String USER_DOES_NOT_EXISTS = "User with email %s does not exists.";

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_DOES_NOT_EXISTS, email)));
    }
}
