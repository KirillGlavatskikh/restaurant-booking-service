package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.EstablishmentFormat;
import com.example.restaurantbookingservice.service.establishmentFormatService.EstablishmentFormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment-format")
@RequiredArgsConstructor
public class EstablishmentFormatController {

    private final EstablishmentFormatService establishmentFormatService;

    @GetMapping("/all")
    public List<EstablishmentFormat> getAll() {
        return establishmentFormatService.getAll();
    }

    @PostMapping("/add-new-format")
    public EstablishmentFormat addNewEstablishmentFormat(@RequestBody EstablishmentFormat establishmentFormat) {
        return establishmentFormatService.addNewEstablishmentFormat(establishmentFormat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEstablishmentFormat(@PathVariable Integer id) {
        establishmentFormatService.deleteEstablishmentFormat(id);
    }
}
