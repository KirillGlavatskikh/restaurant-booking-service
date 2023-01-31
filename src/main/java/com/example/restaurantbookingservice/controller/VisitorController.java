package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Visitor;
import com.example.restaurantbookingservice.service.visitorService.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitor")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorService visitorService;

    @GetMapping("/all")
    public List<Visitor> getAll() {
        return visitorService.getAll();
    }

    @PostMapping("/add-user")
    public Visitor addNewUser(@RequestBody Visitor visitor) {
        return visitorService.addNewUser(visitor);
    }

    @PostMapping("/add-admin")
    public Visitor addNewAdmin(@RequestBody Visitor visitor){
        return visitorService.addNewAdmin(visitor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVisitor(@PathVariable Integer id) {
        visitorService.deleteVisitor(id);
    }
}
