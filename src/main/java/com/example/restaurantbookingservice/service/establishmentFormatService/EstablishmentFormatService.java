package com.example.restaurantbookingservice.service.establishmentFormatService;

import com.example.restaurantbookingservice.model.EstablishmentFormat;

import java.util.List;

public interface EstablishmentFormatService {

    List<EstablishmentFormat> getAll();

    EstablishmentFormat addNewEstablishmentFormat(EstablishmentFormat establishmentFormat);

    void deleteEstablishmentFormat(Integer id);
}
