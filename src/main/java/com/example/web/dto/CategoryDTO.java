package com.example.web.dto;

import com.example.web.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private int categoryId;
    private String categoryName;
    private int parent_id;
    private String description;
    private List<Product> productList;
}
