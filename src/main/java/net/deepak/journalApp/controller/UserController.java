package net.deepak.journalApp.controller;

import net.deepak.journalApp.Entity.JournalEntry;
import net.deepak.journalApp.Entity.User;
import net.deepak.journalApp.service.JournalEntryService;
import net.deepak.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


     @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user ,@PathVariable String userName){
         User userInDb = userService.findByuserName(userName);
         if(userInDb!=null){
             userInDb.setUserName(user.getUserName());
             userInDb.setPassword(user.getPassword());
             userService.saveEntry(userInDb);
         }
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

}
