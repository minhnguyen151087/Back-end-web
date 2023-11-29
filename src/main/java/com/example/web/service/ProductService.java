package com.example.web.service;

import com.example.web.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDTO> getProduct();

    List<ProductDTO> getProductByCategory(int category_id);

    List<ProductDTO> getProductByProductName(String productName);

    List<ProductDTO> getProductFilter(int category_id, String productName);

    ProductDTO update(ProductDTO productDTO, int productId);
}
