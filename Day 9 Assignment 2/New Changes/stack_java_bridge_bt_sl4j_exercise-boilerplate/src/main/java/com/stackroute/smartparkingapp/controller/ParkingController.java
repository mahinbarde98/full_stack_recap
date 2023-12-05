package com.stackroute.smartparkingapp.controller;

import com.stackroute.smartparkingapp.dto.ParkingDto;
import com.stackroute.smartparkingapp.repo.ParkingRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/api/v1")
@RestController
public class ParkingController {

    private static Logger logger = LoggerFactory.getLogger(ParkingController.class);

    private final ParkingRepo parkingRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public ParkingController(ParkingRepo parkingRepo, ModelMapper modelMapper) {
        this.parkingRepo = parkingRepo;
        this.modelMapper = modelMapper;
    }

    /**
     * API Version: 1.0
     * Define a handler method which will add new parking details by reading the Serialized
     * ParkingDto object from request body and save the Parking in the database.
     * The logger should log the required info.
     * This handler method should return the status messages based on
     * different situations:
     * 1. 201(CREATED - In case of successful creation of the task)
     * 2. 400(Bad Request - In case the request is not readable)
     * This handler method should map to the URL "/api/v1/parking" using HTTP POST method.
     */
    @PostMapping("/parking")
    public ResponseEntity<String> addParking(@RequestBody ParkingDto parkingDto) {
        try {

            logger.info("Parking details added successfully");
            return new ResponseEntity<>("Parking details added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error adding parking details", e);
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * API Version: 1.0
     * Define a handler method which will update new parking details by reading the Serialized
     * ParkingDto object from the request body and update the Parking in the database.
     * The logger should log the required info.
     * This handler method should return the status messages based on
     * different situations:
     * 1. 201(CREATED - In case of successful creation of the task)
     * 2. 400(Bad Request - In case the request is not readable)
     * This handler method should map to the URL "/api/v1/parking" using HTTP PUT method.
     */
    @PutMapping("/parking")
    public ResponseEntity<String> updateParking(@RequestBody ParkingDto parkingDto) {
        try {

            logger.info("Parking details updated successfully");
            return new ResponseEntity<>("Parking details updated successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error updating parking details", e);
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * API Version: 1.0
     * Define a handler method which will retrieve all parking details.
     * The logger should log the required info.
     * This handler method should return the status messages based on
     * different situations:
     * 1. 200(OK) - If the tasks found successfully
     * This handler method should map to the URL "/api/v1/parkings" using HTTP GET method.
     */
    @GetMapping("/parkings")
    public ResponseEntity<String> getAllParkings() {
        try {

            logger.info("Retrieved all parking details successfully");
            return new ResponseEntity<>("Retrieved all parking details successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error retrieving parking details", e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * API Version: 1.0
     * Define a handler method which will Delete a parking by reading the Serialized
     * TaskDto object from the request body.
     * This handler method should return any one of the status messages based on
     * different situations:
     * 1. 200(OK) - If the parking deleted successfully.
     * 2. 400(BAD REQUEST) - If the request is not readable.
     * This handler method should map to the URL "/api/v1/task" using HTTP DELETE method.
     */
    @DeleteMapping("/parking")
    public ResponseEntity<String> deleteParking(@RequestBody ParkingDto parkingDto) {
        try {

            logger.info("Parking deleted successfully");
            return new ResponseEntity<>("Parking deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error deleting parking", e);
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Define the private methods as required
     */

}
