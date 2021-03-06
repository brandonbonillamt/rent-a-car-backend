/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentACarBackend;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL - PC
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository crud;

    public List<Message> getAll() {
        return (List<Message>) crud.findAll();
    }

    public Optional<Message> getOne(int id) {
        return crud.findById(id);
    }

    public Message save(Message one) {
        return crud.save(one);
    }
    
    public void delete(Message one) {
        crud.delete(one);
    }
}
