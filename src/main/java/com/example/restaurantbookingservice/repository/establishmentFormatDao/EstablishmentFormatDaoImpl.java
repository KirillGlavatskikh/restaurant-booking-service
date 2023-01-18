package com.example.restaurantbookingservice.repository.establishmentFormatDao;

import com.example.restaurantbookingservice.model.EstablishmentFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EstablishmentFormatDaoImpl implements EstablishmentFormatDao {

    @PersistenceContext
    private EntityManager entityManager;
    private final String GET_ALL = "Select e from EstablishmentFormat e";

    @Override
    public List<EstablishmentFormat> getAll() {
        return entityManager.createQuery(GET_ALL).getResultList();
    }

    @Override
    @Transactional
    public EstablishmentFormat addNewEstablishmentFormat(EstablishmentFormat establishmentFormat) {
        entityManager.persist(establishmentFormat);
        entityManager.flush();
        return establishmentFormat;
    }

    @Override
    @Transactional
    public void deleteEstablishmentFormat(Integer id) {
        EstablishmentFormat establishmentFormat = entityManager.find(EstablishmentFormat.class, id);
        entityManager.remove(establishmentFormat);
        entityManager.flush();
    }
}
