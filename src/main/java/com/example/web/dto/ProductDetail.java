package com.example.web.model.product;

//import com.example.web.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
    private int  productName;
    private String functionProduct;
    private String productsOfUses;
    private String productIngredients;
//    private OrderDetail orderDetail;
}
