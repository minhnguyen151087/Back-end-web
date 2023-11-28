package com.example.web.config;

import com.example.web.dto.UserDTO;
import com.example.web.entity.Role;
import com.example.web.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class JwtUserService implements UserDetailsService {
    private UserService userService;

    public JwtUserService(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {
        UserDTO user = userService.getByUserName(userName);
        if(user == null) {
            throw new UsernameNotFoundException("User no found with username");
        }
        Role role = userService.getRoleByUserId(user.getUser_id());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return new User(user.getUserName(), user.getPassword(),authorities);
    }



}
