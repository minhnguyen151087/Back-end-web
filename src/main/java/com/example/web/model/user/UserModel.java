package com.example.web.model.user;

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
    private Role listRole;
    public UserModel(){
    }
    public UserModel( String token, Role roles) {
        this.token = token;
        this.listRole = roles;
    }
}
