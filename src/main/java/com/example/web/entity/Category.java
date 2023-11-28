package com.example.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Category")
@Subselect("SELECT  * FROM Category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "parent_id")
    private int parent_id;
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> productList;
}
