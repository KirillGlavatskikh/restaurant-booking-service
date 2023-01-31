package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Establishment;
import com.example.restaurantbookingservice.service.establishmentService.EstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment")
@RequiredArgsConstructor
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    @GetMapping("/all")
    public List<Establishment> getAll() {
        return establishmentService.getAll();
    }

    @GetMapping("/{establishmentName}")
    public Establishment getByName(@PathVariable String establishmentName) {
        return establishmentService.getByName(establishmentName);
    }

    @GetMapping("/format/{format}")
    public List<Establishment> getByFormat(@PathVariable String format) {
        return establishmentService.getByFormat(format);
    }

    @GetMapping("/everage_check/{everageCheck}")
    public List<Establishment> getByEverageCheck(@PathVariable Integer everageCheck) {
        return establishmentService.getByEverageCheck(everageCheck);
    }

    @PostMapping("/add-new-establishment")
    public Establishment addNewEstablishment(@RequestBody Establishment establishment) {
        return establishmentService.addNewEstablishment(establishment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEstablishment(@PathVariable Integer id) {
        establishmentService.deleteEstablishment(id);
    }
}
