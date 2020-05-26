package com.sowa.test.spring.jpa.hibernate.demo.controler;

import com.sowa.test.spring.jpa.hibernate.demo.model.Plane;
import com.sowa.test.spring.jpa.hibernate.demo.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaneController {

    private PlaneRepository planeRepository;

    @Autowired
    PlaneController(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @GetMapping("/planes")
    public List<Plane> getAllPlanes() {
        List<Plane> listOfPlanes = planeRepository.findAll();
        return listOfPlanes;
    }

}
