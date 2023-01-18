package com.example.restaurantbookingservice.service.visitorService;

import com.example.restaurantbookingservice.model.Visitor;

import java.util.List;

public interface VisitorService {

    List<Visitor> getAll();

    Visitor addNewVisitor(Visitor visitor);

    void deleteVisitor(Integer id);
}
