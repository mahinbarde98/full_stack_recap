package com.stackroute.smartparkingapp.repo;

import com.stackroute.smartparkingapp.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is used to extend JpaRepository to manipulate/manage Parking related data
 * Annotate this class with @Repository annotation
 *
 * @Repository annotation indicates that an annotated class is a "Repository"
 **/
@Repository
public interface ParkingRepo extends JpaRepository<Parking, Integer> {
}
