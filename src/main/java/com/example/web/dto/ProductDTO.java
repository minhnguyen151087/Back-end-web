package com.example.web.dto;

import com.example.web.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int productId;
    private String productName;
    private double price;
    private String image;
    private int quantity;
    private String status;
    private int categoryId;
    private String description;
    private CategoryDTO category;
}
