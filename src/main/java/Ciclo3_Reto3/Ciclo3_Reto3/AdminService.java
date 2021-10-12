/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3_Reto3.Ciclo3_Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL - PC
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository crudMethods;

    public List<Admin> getAll() {
        return crudMethods.getAll();
    }

    public Optional<Admin> getOne(int id) {
        return crudMethods.getOne(id);
    }

    public Admin save(Admin one) {
        if (one.getIdAdmin() == null) {
            return crudMethods.save(one);
        } else {
            Optional<Admin> evt = crudMethods.getOne(one.getIdAdmin());
            if (evt.isEmpty()) {
                return crudMethods.save(one);
            } else {
                return one;
            }
        }
    }
}