package com.example.web.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
public class UserRequestModel implements Serializable {
    private String userName;
    private String password;
}
