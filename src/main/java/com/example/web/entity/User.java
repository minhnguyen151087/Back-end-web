package com.example.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
@Subselect("SELECT  * FROM USERS")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "user_name")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="contact")
    private String contact;
    @Column(name="address")
    private String address;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
    private Role role;
}
