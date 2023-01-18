package com.example.restaurantbookingservice.repository.establishmentDao;

import com.example.restaurantbookingservice.model.Establishment;

import java.util.List;

public interface EstablishmentDao {

    List<Establishment> getAll();

    Establishment getByName(String establishment_name);

    List<Establishment> getByFormat(String format);

    List<Establishment> getByEverageCheck(Integer everageCheck);

    Establishment addNewEstablishment(Establishment establishment);

    void deleteEstablishment(Integer id);
}
