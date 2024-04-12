package com.example.web.controller;

import com.example.web.dto.ProductDTO;
import com.example.web.dto.ProductDetail;
import com.example.web.entity.Product;
import com.example.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getProduct")
    public ResponseEntity<?> filter(@Valid @RequestParam(required = false, value = "categoryId") int categoryId,
                                    @Valid @RequestParam(required = false, value = "productName") String productName){
        if(productName == null && categoryId != 0){
            List<ProductDTO> productDTOList = productService.getProductByCategory(categoryId);
            return new ResponseEntity<>(productDTOList,HttpStatus.OK);
        }else if(productName != null && categoryId == 0){
            List<ProductDTO> productDTOList = productService.getProductByProductName(productName);
            return new ResponseEntity<>(productDTOList,HttpStatus.OK);
        }else if(productName != null && categoryId != 0){
            List<ProductDTO> productDTOList = productService.getProductFilter(categoryId, productName);
            return new ResponseEntity<>(productDTOList,HttpStatus.OK);
        }
        return null;
    }
    @GetMapping("/getListProduct")
    public ResponseEntity<?> getAllProduct(){
        List<ProductDTO> productDTOList = productService.getProduct();
        return new ResponseEntity<>(productDTOList,HttpStatus.OK);
    }
    @GetMapping("/getProductDetail")
    public ResponseEntity<?> getProductDetail(@RequestParam(value = "productId") int productId){
        ProductDetail productDetail = productService.getProductDetail(productId);
        return new ResponseEntity<>(productDetail,HttpStatus.OK);
    }


}
