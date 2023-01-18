package com.example.restaurantbookingservice.repository.visitorDao;

import com.example.restaurantbookingservice.model.Visitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VisitorDaoImpl implements VisitorDao {
    @PersistenceContext
    private final EntityManager entityManager;

    private final String GET_ALL_PATH = "SELECT v FROM Visitor v";

    @Override
    public List<Visitor> getAll() {
        return entityManager.createQuery(GET_ALL_PATH).getResultList();
    }

    @Override
    @Transactional
    public Visitor addNewVisitor(Visitor visitor) {
        entityManager.persist(visitor);
        entityManager.flush();
        return visitor;
    }

    @Override
    @Transactional
    public void deleteVisitor(Integer id) {
        Visitor visitor = entityManager.find(Visitor.class, id);
        entityManager.remove(visitor);
        entityManager.flush();
    }
}
