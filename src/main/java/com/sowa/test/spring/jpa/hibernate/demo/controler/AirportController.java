package com.sowa.test.spring.jpa.hibernate.demo.controler;

import com.sowa.test.spring.jpa.hibernate.demo.model.Airport;
import com.sowa.test.spring.jpa.hibernate.demo.repository.AirportRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {

    AirportRepository airportRepository;

    public AirportController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @GetMapping("/airports")
    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }
}
