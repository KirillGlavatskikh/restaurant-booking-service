package com.example.restaurantbookingservice.service.visitorService;

import com.example.restaurantbookingservice.model.Visitor;
import com.example.restaurantbookingservice.repository.visitorDao.VisitorDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService {

    private final VisitorDaoImpl visitorDaoImpl;

    @Override
    public List<Visitor> getAll() {
        return visitorDaoImpl.getAll();
    }

    @Override
    public Visitor addNewVisitor(Visitor visitor) {
        return visitorDaoImpl.addNewVisitor(visitor);
    }

    @Override
    public void deleteVisitor(Integer id) {
        visitorDaoImpl.deleteVisitor(id);
    }
}
