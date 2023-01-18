package com.example.restaurantbookingservice.service.establishmentService;

import com.example.restaurantbookingservice.model.Establishment;
import com.example.restaurantbookingservice.repository.establishmentDao.EstablishmentDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService {

    private final EstablishmentDaoImpl establishmentDaoImpl;

    @Override
    public List<Establishment> getAll() {
        return establishmentDaoImpl.getAll();
    }

    @Override
    public Establishment getByName(String establishmentName) {
        return establishmentDaoImpl.getByName(establishmentName);
    }

    @Override
    public List<Establishment> getByFormat(String format) {
        return establishmentDaoImpl.getByFormat(format);
    }

    @Override
    public List<Establishment> getByEverageCheck(Integer everageCheck) {
        return establishmentDaoImpl.getByEverageCheck(everageCheck);
    }

    @Override
    public Establishment addNewEstablishment(Establishment establishment) {
        return establishmentDaoImpl.addNewEstablishment(establishment);
    }

    @Override
    public void deleteEstablishment(Integer id) {
        establishmentDaoImpl.deleteEstablishment(id);
    }
}
