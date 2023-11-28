package com.example.web.service;

import com.example.web.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuService {
    List<Menu> getListMenuByRoleId(int roleId);
}
