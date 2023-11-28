package com.example.web.reponsitory;


import com.example.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsitory extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
    @Query(value = "select * from Users u where u.user_name = :userName",nativeQuery = true)
    User loadUserByUserName(@Param("userName") String userName);
    @Query(value ="select * from User u where u.user_name = :userName and u.password = :password",nativeQuery = true)
    User loadUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    Boolean existsByUserName(String userName);
    @Query(value = "select * from User where role_id = :roleId",nativeQuery = true)
    User getUserByRoleId(@Param("roleId") int roleId);
    @Modifying
    @Query(value = "INSERT INTO Users(user_name,address,contact,password,role_id)VALUES(:userName,:address,:contact,:password,:roleId) ",nativeQuery = true)
    void saveUser(@Param("userName") String userName, @Param("address") String address, @Param("contact") String contact, @Param("password") String password);



}
