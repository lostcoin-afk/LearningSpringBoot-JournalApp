package net.beginner.JournalApp.repository;

import net.beginner.JournalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//MongoRepository provided by spring mongo dependency that performs CRUD operations and other facilites using ORM
//For this ORM go to JournalEntry POJO Class and tell Spring to identify that POJO class as a Documents in a certain Collection in the mongoDb database.
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
