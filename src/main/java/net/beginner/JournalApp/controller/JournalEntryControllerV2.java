package net.beginner.JournalApp.controller;

import net.beginner.JournalApp.entity.JournalEntry;
import net.beginner.JournalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//n MVC architecture for web apps, special @Component classes (like @Controller and @RestController) handle HTTP requests or, we can say mainly provides the endpoints, interact with the model layer (business logic and data), and serve appropriate responses to the view layer.
//In short:
//Controllers process web requests, coordinate with the model, and deliver results to the user interface—this is core to the MVC pattern.
//Then in the services folder the codes for the buisness logic lies where the various services exposed to the client in this controller section is present Check services.
@RestController
@RequestMapping("/journal") // adds mapping on the entire class.
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;
    //    This will contain special types of components specifically endpoints as methods
    @GetMapping("/getVals")//first inherits the journal mapping add abc to it
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }


    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateJournalEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry){

        JournalEntry old = journalEntryService.findById(myId).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!= null && newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && newEntry.getContent().isEmpty() ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }


}
