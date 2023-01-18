package com.example.restaurantbookingservice.repository.establishmentDao;

import com.example.restaurantbookingservice.model.Establishment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EstablishmentDaoImpl implements EstablishmentDao {

    private final String GET_ALL_PATH = "SELECT e FROM Establishment e";
    private final String GET_BY_ESTABLISHMENT_NAME_PATH = "SELECT e FROM Establishment e WHERE e.establishmentName = :name";
    private final String GET_BY_FORMAT_PATH = "SELECT e FROM Establishment e, EstablishmentFormat f " +
            "WHERE e.establishmentFormat = f.formatName AND f.formatName = :format";
    private final String GET_BY_EVERAGE_CHECK_PATH = "SELECT e FROM Establishment e WHERE e.everageCheck = :everageCheck";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Establishment> getAll() {
        return entityManager.createQuery(GET_ALL_PATH).getResultList();
    }

    @Override
    public Establishment getByName(String establishment_name) {
        Query query = entityManager.createQuery(GET_BY_ESTABLISHMENT_NAME_PATH);
        query.setParameter("name", establishment_name);
        return (Establishment) query.getSingleResult();
    }

    @Override
    public List<Establishment> getByFormat(String format) {
        Query query = entityManager.createQuery(GET_BY_FORMAT_PATH);
        query.setParameter("format", format);
        return (List<Establishment>) query.getResultList();
    }

    @Override
    public List<Establishment> getByEverageCheck(Integer everageCheck) {
        Query query = entityManager.createQuery(GET_BY_EVERAGE_CHECK_PATH);
        query.setParameter("everageCheck", everageCheck);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Establishment addNewEstablishment(Establishment establishment) {
        entityManager.persist(establishment);
        entityManager.flush();
        return establishment;
    }

    @Override
    @Transactional
    public void deleteEstablishment(Integer id) {
        Establishment establishment = entityManager.find(Establishment.class, id);
        entityManager.remove(establishment);
        entityManager.flush();
    }
}
