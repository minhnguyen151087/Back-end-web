package com.example.web.model.user;

import com.example.web.dto.MenuDTO;
import com.example.web.entity.Menu;
import com.example.web.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
public class UserModel implements Serializable {
    private String token;
    private String tokenType = "Bearer ";
    private Role Role;
    private List<Menu> menuList;
    public UserModel(){
    }
    public UserModel( String token, Role roles,List<Menu> menuList) {
        this.token = token;
        this.Role = roles;
        this.menuList = menuList;
    }
}
