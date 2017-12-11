package com.mycompany.newsroom.controller;

import com.mycompany.newsroom.domain.Account;
import com.mycompany.newsroom.domain.Category;
import com.mycompany.newsroom.domain.Story;
import com.mycompany.newsroom.repository.CategoryRepository;
import com.mycompany.newsroom.repository.NewsRepository;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@Controller
public class NewsController {
    
    @Autowired
    private NewsRepository newsRepo;
    
    @Autowired
    private CategoryRepository catRepo;
    
    @GetMapping("/")
    public String index() {
        return "redirect:/frontpage";
    }
    
    @GetMapping("/frontpage")
    public String frontPage(Model model) {
        model.addAttribute("categories", this.catRepo.findAll());
        model.addAttribute("stories", this.newsRepo.findAll(new PageRequest(0, 5, Sort.Direction.DESC, "publicationDate")));
        return "frontpage";
    }
    
    @GetMapping("story/{id}")
    public String findOne(Model model, @PathVariable Long id) {
        Story story = this.newsRepo.getOne(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = story.getPublicationDate().format(formatter);
        model.addAttribute("story", story);
        model.addAttribute("date", formattedDateTime);
        return "story";
    }
    
    @GetMapping(path = "/picture/{id}", produces = "image/jpeg")
    @ResponseBody
    public byte[] picContent(@PathVariable Long id) {
        return this.newsRepo.getOne(id).getPicture();
    }
    
    @GetMapping("/newstory")
    public String newstory(Model model) {
        model.addAttribute("categories", this.catRepo.findAll());
        return "newstory";
    }
    
    //@Secured("USER")
    @PostMapping("/newstory")
    public String newStory(@RequestParam String writer, @RequestParam String categories,  @RequestParam String title, @RequestParam String intro, @RequestParam String content, @RequestParam("picture") MultipartFile picture){
        Story story = new Story();
        story.setPublicationDate(LocalDateTime.now());
        story.setTitle(title);
        story.setContent(content);
        story.setIntro(intro);
        story.setWriter(writer);
        
//       ArrayList<Story> list = new ArrayList<>();    
//       for (Long id : categories) {
//           Category cat = this.catRepo.getOne(id);
//           cat.addStory(story);
//           this.catRepo.save(cat);
//           
//           story.addCategory(cat);
//       }
        
        
        
        if (picture.getContentType().equals("image/png") || picture.getContentType().equals("image/jpeg") ) {
            try {
                story.setPicture(picture.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(NewsController.class.getName()).log(Level.WARNING, null, ex);
            }
        }
        this.newsRepo.save(story);
        return "redirect:/frontpage";
    }

}
