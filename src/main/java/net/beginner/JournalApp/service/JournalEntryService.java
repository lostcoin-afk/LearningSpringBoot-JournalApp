package net.beginner.JournalApp.service;

import net.beginner.JournalApp.entity.JournalEntry;
import net.beginner.JournalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    //contains Business logic

    //This is dependency Injection where the spring framework automatically generates the implementation of the Repository Interface and injects it here while runtime
    //But this class does not have any method / or implementation of methods spring manages that to look below how we can save the data of the user so easily using this technique.
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
       return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }

}
