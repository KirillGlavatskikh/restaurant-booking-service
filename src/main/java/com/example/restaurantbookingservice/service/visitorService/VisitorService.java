package com.example.restaurantbookingservice.service.visitorService;

import com.example.restaurantbookingservice.model.Visitor;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface VisitorService extends UserDetailsService {

    List<Visitor> getAll();

    Visitor addNewUser(Visitor visitor);

    Visitor addNewAdmin(Visitor visitor);

    void deleteVisitor(Integer id);
}
