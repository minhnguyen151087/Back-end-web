package com.example.web.service.impl;

import com.example.web.dto.ProductDTO;
import com.example.web.dto.ProductDetail;
import com.example.web.entity.Category;
import com.example.web.entity.Product;
import com.example.web.reponsitory.CategoryRepository;
import com.example.web.reponsitory.ProductRepository;
import com.example.web.service.ProductService;
import com.example.web.util.DTOConventer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private final DTOConventer dtoConventer;

    public ProductServiceImpl(DTOConventer dtoConventer) {
        this.dtoConventer = dtoConventer;
    }

    @Override
    public List<ProductDTO> getProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOList =  new ArrayList<>();
        for(Product product : products){
            productDTOList.add(dtoConventer.productToDto(product));
        }
        return productDTOList;
    }
    @Override
    public List<ProductDTO> getProductByCategory(int category_id){
        List<Product> products = productRepository.findByCategoryId(category_id);
        List<ProductDTO> productDTOList =  new ArrayList<>();
        for(Product product : products){
            productDTOList.add(dtoConventer.productToDto(product));
        }
        return productDTOList;
    }
    @Override
    public List<ProductDTO> getProductByProductName(String productName){
        List<Product> products = productRepository.findByProductName(productName);
        List<ProductDTO> productDTOList =  new ArrayList<>();
        for(Product product : products){
            productDTOList.add(dtoConventer.productToDto(product));
        }
        return productDTOList;
    }
    @Override
    public List<ProductDTO> getProductFilter(int category_id, String productName){
        List<Product> products = productRepository.findByCategoryIdAndProductName(category_id,productName);
        List<ProductDTO> productDTOList =  new ArrayList<>();
        for(Product product : products){
            productDTOList.add(dtoConventer.productToDto(product));
        }
        return productDTOList;
    }
    @Override
    public ProductDTO update(ProductDTO productDTO, int productId){
        Product newProduct  = productRepository.findById(productDTO.getProductId());
        Category category = categoryRepository.findByCategoryID(productDTO.getCategoryId());
        newProduct.setProductName(productDTO.getProductName());
        newProduct.setCategory(category);
        newProduct.setDescription(productDTO.getDescription());
        newProduct.setPrice(productDTO.getPrice());
        newProduct.setImage(productDTO.getImage());
        newProduct.setStatus(productDTO.getStatus());
        newProduct.setQuantity(productDTO.getQuantity());
        return dtoConventer.productToDto(productRepository.save(newProduct));
    }
    @Override
    public ProductDetail getProductDetail(int productId){
        ProductDetail productDetail = productRepository.getProductDetailById(productId);
        return productDetail;
    }
}
