package com.example.web.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Menu",uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id"})})
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int menu_id;
    @Column(name = "name")
    private String menu_name;
    @Column(name="description")
    private String description;
    @Column(name="url")
    private String url;
    @ManyToMany(mappedBy = "menuList")
    private List<Role> RoleList;

}
