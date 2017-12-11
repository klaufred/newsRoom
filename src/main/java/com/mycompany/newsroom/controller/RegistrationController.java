//package com.mycompany.newsroom.controller;
//
//import com.mycompany.newsroom.domain.Account;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import com.mycompany.newsroom.repository.AccountRepository;
//import java.util.Arrays;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//@Controller
//public class RegistrationController {
//
//    @Autowired
//    private AccountRepository accountRepo;
//
//    @GetMapping("/registration")
//    public String view(@ModelAttribute Account account) {
//        return "form";
//    }
//
//    @PostMapping("/registration")
//    public String register(
//            @Valid @ModelAttribute Account account,
//            BindingResult bindingResult) {
//
//        if(bindingResult.hasErrors()) {
//            return "form";
//        }
//        account.setAuthorities(Arrays.asList("ADMIN", "USER"));
//        this.accountRepo.save(account);
//        return "redirect:/success";
//    }
//
//}
