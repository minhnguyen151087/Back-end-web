package com.example.web.reponsitory;

import com.example.web.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "select * from Category where category_id := categoryID",nativeQuery = true)
    Category findByCategoryID(@Param("categoryId") int categoryId);
}
