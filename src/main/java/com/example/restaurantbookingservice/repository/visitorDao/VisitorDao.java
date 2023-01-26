package com.example.restaurantbookingservice.repository.visitorDao;

import com.example.restaurantbookingservice.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VisitorDao extends JpaRepository<Visitor, Integer> {

    Visitor findByFullName(String fullName);

    @Query("SELECT v FROM Visitor v")
    List<Visitor> getAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM Visitor v WHERE v.id = :id")
    void deleteVisitor(Integer id);
}
