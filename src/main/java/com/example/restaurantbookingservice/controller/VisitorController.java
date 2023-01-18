package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Visitor;
import com.example.restaurantbookingservice.service.visitorService.VisitorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitor")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorServiceImpl visitorServiceImpl;

    @GetMapping("/all")
    public List<Visitor> getAll() {
        return visitorServiceImpl.getAll();
    }

    @PostMapping("/add-new")
    public Visitor addNewVisitor(@RequestBody Visitor visitor) {
        return visitorServiceImpl.addNewVisitor(visitor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVisitor(@PathVariable Integer id) {
        visitorServiceImpl.deleteVisitor(id);
    }
}
