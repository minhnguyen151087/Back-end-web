package com.example.web.service.impl;

import com.example.web.entity.Menu;
import com.example.web.reponsitory.MenuRepository;
import com.example.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public List<Menu> getListMenuByRoleId(int roleId) {
        return menuRepository.getMenuByRoleId(roleId);
    }
}
