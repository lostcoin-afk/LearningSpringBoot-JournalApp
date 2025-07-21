package net.beginner.JournalApp.controller;

import net.beginner.JournalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

//n MVC architecture for web apps, special @Component classes (like @Controller and @RestController) handle HTTP requests, interact with the model layer (business logic and data), and serve appropriate responses to the view layer.
//In short:
//Controllers process web requests, coordinate with the model, and deliver results to the user interface—this is core to the MVC pattern.
//
@RestController
@RequestMapping("/_journal") // adds mapping on the entire class.
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    //    This will contain special types of components specifically endpoints as methods
    @GetMapping("/getVals")//first inherits the journal mapping add abc to it
    public List<JournalEntry> getAll(){
       return new ArrayList<>(journalEntries.values());
   }
   @GetMapping("/id/{myId}")
   public JournalEntry getJournalEntryById(@PathVariable long myId){
        return journalEntries.get(myId);
   }

    @PostMapping
   public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
   }

   @PutMapping("/id/{myId}")
   public boolean updateJournalEntry(@PathVariable long myId, @RequestBody JournalEntry myEntry){
        return journalEntries.put(myId,myEntry) != null;
   }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable long myId) {
        return journalEntries.remove(myId) != null;
    }


}
