package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.EstablishmentFormat;
import com.example.restaurantbookingservice.service.establishmentFormatService.EstablishmentFormatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment-format")
@RequiredArgsConstructor
public class EstablishmentFormatController {

    private final EstablishmentFormatServiceImpl establishmentFormatServiceImpl;

    @GetMapping("/all")
    public List<EstablishmentFormat> getAll() {
        return establishmentFormatServiceImpl.getAll();
    }

    @PostMapping("/add-new-format")
    public EstablishmentFormat addNewEstablishmentFormat(@RequestBody EstablishmentFormat establishmentFormat) {
        return establishmentFormatServiceImpl.addNewEstablishmentFormat(establishmentFormat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEstablishmentFormat(@PathVariable Integer id) {
        establishmentFormatServiceImpl.deleteEstablishmentFormat(id);
    }
}
