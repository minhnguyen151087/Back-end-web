package com.example.web.service;

import com.example.web.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDTO> getProduct();
    ProductDTO update(ProductDTO productDTO, int productId);
}
