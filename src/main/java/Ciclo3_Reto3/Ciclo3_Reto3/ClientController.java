/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3_Reto3.Ciclo3_Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL - PC
 */
@RestController
@RequestMapping("api/Client")
public class ClientController {
    
    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getOne(@PathVariable("id") int id) {
        return service.getOne(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client one) {
        return service.save(one);
    }
}
