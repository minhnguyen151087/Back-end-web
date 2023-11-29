package com.example.web.reponsitory;

import com.example.web.dto.ProductDTO;
import com.example.web.entity.Menu;
import com.example.web.entity.Product;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select p.product_name,p.product_name,p.price,p.image,p.status,p.description, c.category_name from \n" +
            "products p inner join Category c on p.category_id = c.category_id", nativeQuery = true)
    List<ProductDTO> listProduct();
//    @Query(value = "select p.product_name,p.product_name,p.price,p.image,p.status,p.description, c.category_name from \n" +
//            "products p inner join Category c on p.category_id = c.category_id where p.product_id = :product_id", nativeQuery = true)
//    ProductDTO findById(@Param("product_id") int product_id);
    @Query(value = "select * from Products  where product_id = :productId", nativeQuery = true)
    Product findById(@Param("productId")int productId);
    @Query(value ="select * from Products where category_id = :categoryId", nativeQuery = true)
    List<ProductDTO> findByCategoryId(@Param("categoryId")int categoryId);
    List<ProductDTO> findByProductName(String productName);
    @Query(value ="select * from Products where category_id = :categoryId and productName = :productName", nativeQuery = true)
    List<ProductDTO> findByCategoryIdAndProductName(@Param("categoryId")int categoryId,@Param("productName") String productName);

}
