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
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository crud;

    public List<Client> getAll() {
        return (List<Client>) crud.findAll();
    }

    public Optional<Client> getOne(int id) {
        return crud.findById(id);
    }

    public Client save(Client one) {
        return crud.save(one);
    }
    
    public void delete(Client one) {
        crud.delete(one);
    }
}
