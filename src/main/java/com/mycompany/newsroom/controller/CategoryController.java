package com.mycompany.newsroom.controller;

import com.mycompany.newsroom.domain.Category;
import com.mycompany.newsroom.repository.CategoryRepository;
import com.mycompany.newsroom.repository.NewsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepo;
    
    @Autowired
    private NewsRepository newsRepo;
    
    @GetMapping("/categories/nav")
    public String categoriesForNavigation(Model model) {
        model.addAttribute("categories", this.categoryRepo.findAll());
        return "categories";
    }
    
    @GetMapping("/categories")
    public List<Category> categories() {
        return this.categoryRepo.findAll();
    }
    
    @GetMapping("/categories/{id}")
    public String findCategory(Model model, @PathVariable Long id) {
        model.addAttribute("categories", this.categoryRepo.findAll());
        model.addAttribute("category", this.categoryRepo.getOne(id));
        model.addAttribute("stories", this.newsRepo.findAll(new PageRequest(0, 10, Sort.Direction.DESC, "categories")));
        return "category";
    }
    
    //@Secured("ADMIN")
    @PostMapping("/categories")
    public String addCategories(@RequestParam String name, @RequestParam String description) {
        Category cat = new Category();
        cat.setDescription(description);
        cat.setName(name);
        this.categoryRepo.save(cat);
        return "redirect:/frontpage";
    }
}
