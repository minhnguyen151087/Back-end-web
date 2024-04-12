package com.example.web.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Subselect;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles",uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id"})})
@Subselect("SELECT  * From ROLES")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> userList;
    @ManyToMany
    @JoinTable(name = "RoleMenu",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private List<Menu> menuList;


}
