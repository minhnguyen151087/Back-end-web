package com.example.web.reponsitory;

import com.example.web.dto.MenuDTO;
import com.example.web.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query(value ="select * from menu m where m.menu_id in(select mr.menu_id from RoleMenu mr where role_id = :roleId) ", nativeQuery = true)
    List<Menu> getMenuByRoleId(@Param("roleId") int roleId);
}
