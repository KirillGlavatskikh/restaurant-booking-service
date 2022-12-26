package com.example.restaurantbookingservice.service.establishmentService;

import com.example.restaurantbookingservice.model.Establishment;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EstablishmentService {

    List<Establishment> getAll();

    Establishment getByName(String establishmentName);

    List<Establishment> getByFormat(String format);

    List<Establishment> getByEverageCheck(Integer everageCheck);

    Establishment addNewEstablishment(Establishment establishment);

    void deleteEstablishment(Integer id);
}
