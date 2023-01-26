package com.example.restaurantbookingservice.service.establishmentService;

import com.example.restaurantbookingservice.model.Establishment;
import com.example.restaurantbookingservice.repository.establishmentDao.EstablishmentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService {

    private final EstablishmentDao establishmentDao;

    @Override
    public List<Establishment> getAll() {
        return establishmentDao.getAll();
    }

    @Override
    public Establishment getByName(String establishmentName) {
        return establishmentDao.getByName(establishmentName);
    }

    @Override
    public List<Establishment> getByFormat(String format) {
        return establishmentDao.getByFormat(format);
    }

    @Override
    public List<Establishment> getByEverageCheck(Integer everageCheck) {
        return establishmentDao.getByEverageCheck(everageCheck);
    }

    @Override
    public Establishment addNewEstablishment(Establishment establishment) {
        return establishmentDao.addNewEstablishment(establishment);
    }

    @Override
    public void deleteEstablishment(Integer id) {
        establishmentDao.deleteEstablishment(id);
    }
}
