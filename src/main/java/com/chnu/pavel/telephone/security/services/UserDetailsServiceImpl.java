package com.chnu.pavel.telephone.security.services;

import com.chnu.pavel.telephone.dao.user.interfaces.UserDAO;
import com.chnu.pavel.telephone.model.User;
import com.chnu.pavel.telephone.repository.user.UserRepository;
import com.chnu.pavel.telephone.security.userdetails.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.UserDetailsServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.06.2021|21:11
 * @Version UserDetailsServiceImpl: 1.0
 */

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }
}
