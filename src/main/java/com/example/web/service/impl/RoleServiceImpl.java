package com.example.web.service.impl;

import com.example.web.entity.Menu;
import com.example.web.entity.Role;
import com.example.web.reponsitory.RoleRepository;
import com.example.web.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("RoleService")
@Slf4j
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Override
    public List<Menu> getListMenuByUserId(int userId) {
        return roleRepository.getMenuByUserId(userId);
    }
}
