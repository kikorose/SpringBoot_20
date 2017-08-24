package com.example.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {
    private UserRepository userRepositoryserRepository;

    public SSUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUsername(String username)
        throws UsernameNotFoundException{
        try {
            User user = userRepository.findByUsername(username);
            if (user == null){
                return new org.springframework.security..core.userdetails.User(
                        user.getUsername(),
                        user.getpassword(),
                        getAuthorities(user));
            }catch (Exception e){
                throw new UsernameNotFoundException("User not found")
            }

        private Set<GrantedAuthority> getAuthorities(user user){
            Set<Role role> authority
                    = new HashSet<GrantedAuthority>();
            for (Rolr role : user.getRoles()){
                GrantedAuthority grantedAuthority
                        = new SimpleGrantedAuthority(role.getRole());
                authorities.add(grantedAuthority);
            }
            return authorities;
        }
    }

