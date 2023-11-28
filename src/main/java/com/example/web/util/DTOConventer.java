package com.example.web.util;

import com.example.web.dto.CategoryDTO;
import com.example.web.dto.ProductDTO;
import com.example.web.dto.RoleDTO;
import com.example.web.dto.UserDTO;
import com.example.web.entity.Category;
import com.example.web.entity.Product;
import com.example.web.entity.Role;
import com.example.web.entity.User;
import com.example.web.model.product.ProductDetail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOConventer {
    private final ModelMapper modelMapper;

    public DTOConventer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO productToDto (Product product){
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        CategoryDTO cartegoryResponse = categoryToDTO(product.getCategory());
        productDTO.setCategory(cartegoryResponse);
        return productDTO;
    }
    public ProductDetail productDetailToDTO(Product product){
        return modelMapper.map(product, ProductDetail.class);
    }

    public CategoryDTO categoryToDTO(Category category){
        return modelMapper.map(category, CategoryDTO.class);
    }
    public RoleDTO roleToDto(Role role){
        return modelMapper.map(role, RoleDTO.class);
    }
    public UserDTO userToDto(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        RoleDTO roleDTOResponse = roleToDto(user.getRole());
        userDTO.setRole(roleDTOResponse);
        return userDTO;
    }
}
