package net.deepak.journalApp.controller;

import net.deepak.journalApp.Entity.User;
import net.deepak.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
     private UserService userService;
    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping
    public void createUser(@Valid @RequestBody User user){
        userService.saveEntry(user);

    }
}
