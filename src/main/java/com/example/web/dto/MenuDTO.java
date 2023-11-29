package com.example.web.dto;

import com.example.web.entity.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuDTO implements Serializable {
    private int menu_id;
    private String menu_name;
    private String description;
    private String url;
    private List<Role> role;
}
