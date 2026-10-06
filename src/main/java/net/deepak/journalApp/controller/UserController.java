package net.deepak.journalApp.controller;

import net.deepak.journalApp.Entity.JournalEntry;
import net.deepak.journalApp.Entity.User;
import net.deepak.journalApp.repository.UserRepo;
import net.deepak.journalApp.service.JournalEntryService;
import net.deepak.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
     @Autowired
    private UserService userService;
     @Autowired
     private UserRepo userRepo;


     @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
         Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
         String userName=authentication.getName();
         User userInDb = userService.findByuserName(userName);

         userInDb.setUserName(user.getUserName());
         userInDb.setPassword(user.getPassword());
         userService.saveEntry(userInDb);

         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
     @DeleteMapping()
     public ResponseEntity<?> deleteUserName(){
         Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
         userRepo.deleteByUsername(authentication.getName());
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

}
