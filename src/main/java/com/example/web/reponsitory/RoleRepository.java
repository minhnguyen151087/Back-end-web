package com.example.web.reponsitory;

import com.example.web.entity.Menu;
import com.example.web.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select * from Roles r where r.role_id  in (select u.role_id from Users u where u.user_name = :userName)", nativeQuery = true)
    Role getRoleByUserId(@Param("userName") int UserId);
    Role findRoleByRoleName(String roleName);

    @Query(value ="select * from menu m where m.menu_id in(select mr.menu_id from RoleMenu mr where mr.role_id \n" +
            "in(select r.role_id from Roles r where r.user_id = :userId)", nativeQuery = true)
    List<Menu> getMenuByUserId(@Param("userId") int userId);
}
