package com.example.restaurantbookingservice.service.visitorService;

import com.example.restaurantbookingservice.model.Role;
import com.example.restaurantbookingservice.model.Visitor;
import com.example.restaurantbookingservice.repository.visitorDao.VisitorDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VisitorServiceImpl implements VisitorService {

    private final VisitorDao visitorDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException {
        return visitorDao.findByFullName(fullName);
    }

    @Override
    public List<Visitor> getAll() {
        return visitorDao.getAll();
    }

    @Override
    public Visitor addNewUser(Visitor visitor) {

        visitor.setFullName(visitor.getFullName());
        visitor.setPassword(passwordEncoder.encode(visitor.getPassword()));
        visitor.getRole().add(Role.USER);
        visitor.setIsActive(true);
        log.info("User created!");
        visitorDao.save(visitor);
        return visitor;
    }

    @Override
    public Visitor addNewAdmin(Visitor visitor) {
            visitor.setPassword(passwordEncoder.encode(visitor.getPassword()));
            visitor.getRole().add(Role.ADMIN);
            visitor.setIsActive(true);
            log.info("Admin created!");
            visitorDao.save(visitor);
            return visitor;

    }

    @Override
    public void deleteVisitor(Integer id) {
        visitorDao.deleteVisitor(id);
    }
}
