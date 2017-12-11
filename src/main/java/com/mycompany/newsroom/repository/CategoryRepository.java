package com.mycompany.newsroom.repository;

import com.mycompany.newsroom.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
