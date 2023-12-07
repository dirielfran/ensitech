package com.eareiza.ensitech.backend.service;

import com.eareiza.ensitech.backend.interfeces.IUserService;
import com.eareiza.ensitech.backend.model.User;
import com.eareiza.ensitech.backend.repository.IUserRepository;
import com.eareiza.ensitech.backend.utileria.Utileria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends CommonServiceImpl<User, IUserRepository> implements IUserService, UserDetailsService {

    @Autowired
    private IUserRepository userRepository;



    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private final Utileria util= new Utileria();



    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario = userRepository.findByUsername(username);

        if(usuario == null) {
            logger.error("Error en el login: no existe el usuario "+username+" en el sistema!");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario \"+username+\" en el sistema!");
        }

        logger.info("Usuario: "+username);
        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> logger.info("Role: "+authority.getAuthority()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
