package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @GetMapping()
    public List<JournalEntry>getAll(){
            return null;
    }
    @PostMapping()
    public boolean createEntry(@RequestBody JournalEntry myEntry){

        return true;
    }
    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable Long myid){
       return null;
    }
    @DeleteMapping("id/{myid}")
    public JournalEntry deleteEntryById(@PathVariable Long myid){
        return null;
    }
    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return null;
    }
}
