package com.example.web.model.user;

import com.example.web.dto.MenuDTO;
import com.example.web.entity.Menu;
import com.example.web.entity.Role;
import com.example.web.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
public class UserModel implements Serializable {
    private User user;
    private String token;
    private String tokenType = "Bearer ";
    private Role Role;
    private List<Menu> menuList;
    public UserModel(){
    }
    public UserModel(User user,String token, Role roles,List<Menu> menuList) {
        this.user = user;
        this.token = token;
        this.Role = roles;
        this.menuList = menuList;
    }
}
