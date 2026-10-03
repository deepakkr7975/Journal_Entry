package net.deepak.journalApp.service;

import net.deepak.journalApp.Entity.JournalEntry;
import net.deepak.journalApp.Entity.User;
import net.deepak.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Autowired
    private UserService userService;
    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        User user=userService.findByuserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved=journalEntryRepo.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry>getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id, String userName){
        User user=userService.findByuserName(userName);
        user.getJournalEntries().removeIf(x ->x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepo.deleteById(id);
    }
}
