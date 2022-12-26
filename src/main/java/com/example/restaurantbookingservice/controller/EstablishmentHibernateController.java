package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Establishment;
import com.example.restaurantbookingservice.service.establishmentService.EstablishmentServiceHibernateImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment-hibernate")
@RequiredArgsConstructor
public class EstablishmentHibernateController {

    private final EstablishmentServiceHibernateImpl establishmentServiceHibernateImpl;

    @GetMapping("/get-all")
    public List<Establishment> getAll() {
        return establishmentServiceHibernateImpl.getAll();
    }

    @GetMapping("/get-by-name/{establishmentName}")
    public Establishment getByName(@PathVariable String establishmentName) {
        return establishmentServiceHibernateImpl.getByName(establishmentName);
    }

    @GetMapping("/get-by-format/{establishmentFormat}")
    public List<Establishment> getByFormat(@PathVariable String establishmentFormat) {
        return establishmentServiceHibernateImpl.getByFormat(establishmentFormat);
    }

    @GetMapping("/get-by-everage-check/{everageCheck}")
    public List<Establishment> getByEverageCheck(@PathVariable Integer everageCheck){
        return establishmentServiceHibernateImpl.getByEverageCheck(everageCheck);
    }

    @PostMapping("/add-new-establishment")
    public Establishment addNewEstablishment(@RequestBody Establishment establishment){
        return establishmentServiceHibernateImpl.addNewEstablishment(establishment);
    }

    @DeleteMapping("/delete-establishment/{id}")
    public void deleteEstablishment(@PathVariable Integer id){
        establishmentServiceHibernateImpl.deleteEstablishment(id);
    }
}
