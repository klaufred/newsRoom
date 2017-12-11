package com.mycompany.newsroom.repository;

import com.mycompany.newsroom.domain.Category;
import com.mycompany.newsroom.domain.Story;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewsRepository extends JpaRepository<Story, Long>{
}
