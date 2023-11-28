package com.example.web.service;

import com.example.web.entity.Menu;
import com.example.web.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleService {
    List<Menu> getListMenuByUserId(int userId);
}
