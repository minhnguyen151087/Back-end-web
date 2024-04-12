package com.example.web.controller;


import com.example.web.config.JwtTokenUtil;
import com.example.web.config.JwtUserService;
import com.example.web.dto.MenuDTO;
import com.example.web.dto.UserDTO;
import com.example.web.entity.Menu;
import com.example.web.entity.Role;
import com.example.web.entity.User;
import com.example.web.model.user.UserModel;
import com.example.web.model.user.UserRequestModel;
import com.example.web.reponsitory.UserReponsitory;
import com.example.web.service.MenuService;
import com.example.web.service.RoleService;
import com.example.web.service.UserService;
import com.example.web.util.DTOConventer;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUserService jwtUserService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserReponsitory userReponsitory;
    @Autowired
    RoleService roleService;
    @Autowired
    DTOConventer dtoConventer;
    @Autowired
    MenuService menuService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@Valid @RequestBody UserRequestModel userRequest) {
        User user = userService.getUserByUserNamePassword(userRequest.getUserName(), userRequest.getPassword());
        if(userRequest != null){
        dtoConventer.userToDto(user);
        //authenticate thư viện dùng để phân quyền trong spring boots
        //lưu dữ liệu userName pass vào header
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUserName(),
                        userRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //chuyển dữ liệu password sang dạng mã hóa token
        String token = jwtTokenUtil.generateToken(authentication);
        //get role thuộc người dùng này
        Role role = userService.getRoleByUserId(user.getUser_id());
        List<Menu> menuList = menuService.getListMenuByRoleId(role.getRoleId());
        return new ResponseEntity<>(new UserModel(user,token, role,menuList), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Tên đăng nhập hoặc mật khẩu không đúng!", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
        if(userReponsitory.existsByUserName(userDTO.getUserName())){
            return new ResponseEntity<>("Người dùng đã tồn tại ", HttpStatus.BAD_REQUEST);
        }
        userService.signUp(userDTO);
        return new ResponseEntity<>("Đăng ký thành công",HttpStatus.OK);
    }

}
