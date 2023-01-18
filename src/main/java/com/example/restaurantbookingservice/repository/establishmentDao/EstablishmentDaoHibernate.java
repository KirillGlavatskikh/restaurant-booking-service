package com.example.restaurantbookingservice.repository.establishmentDao;

import com.example.restaurantbookingservice.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstablishmentDaoHibernate extends JpaRepository<Establishment, String> {
    @Query("SELECT e FROM Establishment e WHERE e.establishmentName = :establishmentName")
    Establishment getByName(String establishmentName);

    @Query("SELECT e FROM Establishment e, EstablishmentFormat f " +
            "WHERE e.establishmentFormat = f.formatName AND f.formatName = :establishmentFormat")
    List<Establishment> getByFormat(String establishmentFormat);

    @Query("SELECT e FROM Establishment e WHERE e.everageCheck = :everageCheck")
    List<Establishment> getByEverageCheck(Integer everageCheck);

    @Query("DELETE FROM Establishment e WHERE e.id = :id")
    void deleteEstablishment(Integer id);
}
