
package com.mycompany.newsroom.controller;

import com.mycompany.newsroom.domain.Account;
import com.mycompany.newsroom.domain.Category;
import com.mycompany.newsroom.repository.AccountRepository;
import com.mycompany.newsroom.repository.CategoryRepository;
import com.mycompany.newsroom.repository.NewsRepository;
import java.util.Arrays;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class DefaultController {
    
    @Autowired
    private CategoryRepository catRepo;
//    
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    
    @Autowired
    private AccountRepository accountRepository;
 
    
    @PostConstruct
    public void setUp() {
//        if (accountRepository.findByUsername("admin") != null) {
//            return;
//        }
 
        TimeZone.setDefault(TimeZone.getTimeZone("EET"));
        
        Category sports = new Category();
        sports.setName("Sports");
        sports.setDescription("All things sports");
        this.catRepo.save(sports);
        
        Category computers = new Category();
        computers.setName("Computers");
        computers.setDescription("All things computers");
        this.catRepo.save(computers);
        
        Category politics = new Category();
        politics.setName("Politics");
        politics.setDescription("All things political");
        this.catRepo.save(politics);
        
        Category international = new Category();
        international.setName("International");
        international.setDescription("What's happening around the world");
        this.catRepo.save(international);
        
        Category lifestyle = new Category();
        lifestyle.setName("Lifestyle");
        lifestyle.setDescription("How to live");
        this.catRepo.save(lifestyle);
        
//        Account admin = new Account();
//        admin.setUsername("admin");
//        admin.setPassword(passwordEncoder.encode("admin"));
//        admin.setAuthorities(Arrays.asList("ADMIN", "USER"));
//        this.accountRepository.save(admin);
    }
}
