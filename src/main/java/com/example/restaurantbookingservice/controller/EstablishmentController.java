package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Establishment;
import com.example.restaurantbookingservice.service.establishmentService.EstablishmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment")
@RequiredArgsConstructor
public class EstablishmentController {

    private final EstablishmentServiceImpl establishmentServiceImpl;

    @GetMapping("/all")
    public List<Establishment> getAll() {
        return establishmentServiceImpl.getAll();
    }

    @GetMapping("/{establishmentName}")
    public Establishment getByName(@PathVariable String establishmentName) {
        return establishmentServiceImpl.getByName(establishmentName);
    }

    @GetMapping("/format/{format}")
    public List<Establishment> getByFormat(@PathVariable String format) {
        return establishmentServiceImpl.getByFormat(format);
    }

    @GetMapping("/everage_check/{everageCheck}")
    public List<Establishment> getByEverageCheck(@PathVariable Integer everageCheck) {
        return establishmentServiceImpl.getByEverageCheck(everageCheck);
    }

    @PostMapping("/addNewEstablishment")
    public Establishment addNewEstablishment(@RequestBody Establishment establishment) {
        return establishmentServiceImpl.addNewEstablishment(establishment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEstablishment(@PathVariable Integer id) {
        establishmentServiceImpl.deleteEstablishment(id);
    }
}
