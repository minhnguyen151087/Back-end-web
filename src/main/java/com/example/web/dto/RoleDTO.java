package com.example.web.dto;


import com.example.web.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {
    private int roleId;
    private String roleName;
    private String description;
    private List<UserDTO> userList;
    private List<MenuDTO> menus;
}
