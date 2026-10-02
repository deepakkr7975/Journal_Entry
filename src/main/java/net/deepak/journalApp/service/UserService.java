package net.deepak.journalApp.service;

import net.deepak.journalApp.Entity.JournalEntry;
import net.deepak.journalApp.Entity.User;
import net.deepak.journalApp.repository.JournalEntryRepo;
import net.deepak.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    @Autowired
    private UserRepo UserRepo;

    public void saveEntry(User user){
        UserRepo.save(user);
    }
    public List<User>getAll(){
        return UserRepo.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return UserRepo.findById(id);
    }
    public void deleteById(ObjectId id){
        UserRepo.deleteById(id);
    }
    public User findByuserName(String userName){
        return UserRepo.findByuserName(userName);
    }
}
