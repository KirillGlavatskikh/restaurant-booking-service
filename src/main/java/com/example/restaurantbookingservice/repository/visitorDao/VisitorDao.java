package com.example.restaurantbookingservice.repository.visitorDao;

import com.example.restaurantbookingservice.model.Visitor;

import java.util.List;

public interface VisitorDao {

    List<Visitor> getAll();

    Visitor addNewVisitor(Visitor visitor);

    void deleteVisitor(Integer id);
}
