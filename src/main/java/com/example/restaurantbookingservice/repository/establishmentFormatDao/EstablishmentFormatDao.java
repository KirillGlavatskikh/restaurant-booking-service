package com.example.restaurantbookingservice.repository.establishmentFormatDao;

import com.example.restaurantbookingservice.model.EstablishmentFormat;

import java.util.List;

public interface EstablishmentFormatDao {

    List<EstablishmentFormat> getAll();

    EstablishmentFormat addNewEstablishmentFormat(EstablishmentFormat establishmentFormat);

    void deleteEstablishmentFormat(Integer id);
}
