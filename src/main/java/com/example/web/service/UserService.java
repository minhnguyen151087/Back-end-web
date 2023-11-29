package com.example.web.service;

import com.example.web.dto.MenuDTO;
import com.example.web.dto.UserDTO;
import com.example.web.entity.Menu;
import com.example.web.entity.Role;
import com.example.web.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO getByUserName(String userName);

    Role getRoleByUserId(int userId);

    void signUp(UserDTO userDTO);

    User checkLogin(String userName, String password);

    User getUserByUserNamePassword(String userName, String password);
}
