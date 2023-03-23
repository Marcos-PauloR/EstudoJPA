package com.cursojpa.cursojpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cursojpa.cursojpa.domain.Cliente;
import com.cursojpa.cursojpa.repository.ClienteRepository;
import com.cursojpa.cursojpa.security.UserSS;

@Service
public class UserDatilsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cli = clienteRepository.findByEmail(username);
        
        if(cli==null){
            throw new UsernameNotFoundException(username);
        }        
        return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
    }
    
}
