package com.example.web.service.impl;



import com.example.web.dto.UserDTO;

import com.example.web.entity.Role;
import com.example.web.entity.User;
import com.example.web.reponsitory.RoleRepository;
import com.example.web.reponsitory.UserReponsitory;
import com.example.web.service.UserService;
import com.example.web.util.DTOConventer;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service("UserService")
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserReponsitory userReponsitory;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final DTOConventer dtoConventer;

    public UserServiceImpl( UserReponsitory userReponsitory, ModelMapper modelMapper, RoleRepository roleRepository, DTOConventer dtoConventer) {
        this.userReponsitory = userReponsitory;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.dtoConventer = dtoConventer;
    }
    @Override
    public UserDTO getByUserName(String userName) {
        User user = userReponsitory.findByUserName(userName);
        return dtoConventer.userToDto(user);
    }
    @Override
    public Role getRoleByUserId(int userId) {
        return roleRepository.getRoleByUserId(userId);
    }
    @Override
    public void signUp(UserDTO userDTO){
        User newUser = new User();
        newUser.setUserName(userDTO.getUserName());
        newUser.setPassword(userDTO.getPassword());
        newUser.setAddress(userDTO.getAddress());
        newUser.setContact(userDTO.getContact());
        Role role = roleRepository.findRoleByRoleName("customer");
        newUser.setRole(role);
        userReponsitory.saveUser(newUser.getUserName(), newUser.getAddress(), newUser.getContact(), newUser.getPassword());
    }
    @Override
    public User checkLogin(String userName, String password){
        User user = userReponsitory.loadUserByUserNameAndPassword(userName,password);
        if(user == null){
            log.error("User name or password is wrong!");
            return null;
        }else{
            return user;
        }
    }
    @Override
    public User getUserByUserNamePassword(String userName, String password){
        return userReponsitory.loadUserByUserNameAndPassword(userName,password);
    }
}
