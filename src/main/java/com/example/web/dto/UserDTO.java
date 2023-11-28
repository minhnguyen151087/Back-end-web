package com.example.web.dto;

import com.example.web.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int user_id;
    private String userName;
    private String password;
    private String contact;
    private RoleDTO role;
    private List<MenuDTO> menuDTOS;
    private String address;
}
