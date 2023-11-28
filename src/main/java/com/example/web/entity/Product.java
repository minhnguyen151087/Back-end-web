package com.example.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
@Subselect("SELECT  * FROM Products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_mame")
    private String productName;
    @Column(name = "price")
    private double price;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @Column(name = "image")
    private String image;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "status")
    private String status;
    @Column(name = "description")
    private String description;
    @Column(name = "function_product")
    private String functionProduct;
    @Column(name = "products_of_uses")
    private String productsOfUses;
    @Column(name = "product_ingredients")
    private String productIngredients;
//    @OneToOne(mappedBy = "product")
//    private OrderDetail orderDetail;

}
