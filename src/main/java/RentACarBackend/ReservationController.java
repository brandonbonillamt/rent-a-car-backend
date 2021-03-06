/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentACarBackend;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL - PC
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/Reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getOne(@PathVariable("id") int id) {
        return service.getOne(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation one) {
        return service.save(one);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation one) {
        return service.update(one);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
    
    
    @GetMapping("/report-dates/{start}/{end}")
    public List<Reservation> reportDates(@PathVariable("start") String start, @PathVariable("end") String end) {
        return service.getReservationPeriod(start, end);
    }
    
    @GetMapping("/report-status")
    public StatusAmount reportStatus() {
        return service.getStatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> reportClients() {
        return service.getTopClients();
    }
    
}
