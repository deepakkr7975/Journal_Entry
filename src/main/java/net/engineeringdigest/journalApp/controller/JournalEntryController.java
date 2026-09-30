package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    private Map<Long,JournalEntry>journalentries=new HashMap<>();
    @GetMapping()
    public List<JournalEntry>getAll(){
            return new ArrayList<>(journalentries.values());
    }
    @PostMapping()
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalentries.put(myEntry.getId(),myEntry);
        return true;
    }
    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable Long myid){
        return journalentries.get(myid);
    }
    @DeleteMapping("id/{myid}")
    public JournalEntry deleteEntryById(@PathVariable Long myid){
        return journalentries.remove(myid);
    }
    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalentries.put(id,myEntry);
    }
}
