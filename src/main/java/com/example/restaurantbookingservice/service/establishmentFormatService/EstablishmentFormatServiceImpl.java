package com.example.restaurantbookingservice.service.establishmentFormatService;

import com.example.restaurantbookingservice.model.EstablishmentFormat;
import com.example.restaurantbookingservice.repository.establishmentFormatDao.EstablishmentFormatDao;
import com.example.restaurantbookingservice.repository.establishmentFormatDao.EstablishmentFormatDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstablishmentFormatServiceImpl implements EstablishmentFormatService {

    private final EstablishmentFormatDaoImpl establishmentFormatDaoImpl;

    @Override
    public List<EstablishmentFormat> getAll() {
        return establishmentFormatDaoImpl.getAll();
    }

    @Override
    public EstablishmentFormat addNewEstablishmentFormat(EstablishmentFormat establishmentFormat) {
        return establishmentFormatDaoImpl.addNewEstablishmentFormat(establishmentFormat);
    }

    @Override
    public void deleteEstablishmentFormat(Integer id) {
        establishmentFormatDaoImpl.deleteEstablishmentFormat(id);
    }
}
