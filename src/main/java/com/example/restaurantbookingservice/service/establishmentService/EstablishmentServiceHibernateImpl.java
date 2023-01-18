package com.example.restaurantbookingservice.service.establishmentService;

import com.example.restaurantbookingservice.model.Establishment;
import com.example.restaurantbookingservice.repository.establishmentDao.EstablishmentDaoHibernate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EstablishmentServiceHibernateImpl implements EstablishmentService{

    private final EstablishmentDaoHibernate establishmentDaoHibernate;
    @Override
    public List<Establishment> getAll() {
        return establishmentDaoHibernate.findAll();
    }

    @Override
    public Establishment getByName(String establishmentName) {
        return establishmentDaoHibernate.getByName(establishmentName);
    }

    @Override
    public List<Establishment> getByFormat(String establishmentFormat) {
        return establishmentDaoHibernate.getByFormat(establishmentFormat);
    }

    @Override
    public List<Establishment> getByEverageCheck(Integer everageCheck) {
        return establishmentDaoHibernate.getByEverageCheck(everageCheck);
    }

    @Override
    public Establishment addNewEstablishment(Establishment establishment) {
        return establishmentDaoHibernate.save(establishment);
    }

    @Override
    public void deleteEstablishment(Integer id) {
        establishmentDaoHibernate.deleteEstablishment(id);
    }
}
