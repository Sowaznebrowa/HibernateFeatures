package com.sowa.test.spring.jpa.hibernate.demo.operations;

import com.sowa.test.spring.jpa.hibernate.demo.model.Airport;
import com.sowa.test.spring.jpa.hibernate.demo.model.Model;
import com.sowa.test.spring.jpa.hibernate.demo.repository.AirportRepository;
import com.sowa.test.spring.jpa.hibernate.demo.repository.ModelRepository;
import com.sowa.test.spring.jpa.hibernate.demo.repository.PlaneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Slf4j
public class DataManipulator {

    private PlaneRepository planeRepo;
    private ModelRepository modelRepository;
    private AirportRepository airportRepository;
    private EntityManagerFactory entityManagerFactory;

    public DataManipulator(PlaneRepository planeRepo, ModelRepository modelRepository,
                           AirportRepository airportRepository, EntityManagerFactory entityManagerFactory) {
        this.planeRepo = planeRepo;
        this.modelRepository = modelRepository;
        this.airportRepository = airportRepository;
        this.entityManagerFactory = entityManagerFactory;
    }

    public void makeSomeDBChanges() {
        log.info("DBManipulationStart");

        //Use JPA EntityManager to change planes description
        EntityManager em1 = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = em1.getTransaction();
        em1.getTransaction()
           .begin();

        var planes = planeRepo.findAll();
        planes.forEach(plane -> {
            plane.setDescription(plane.getDescription()
                                      .concat("PL"));
        });
        planeRepo.saveAll(planes);
        em1.getTransaction()
           .commit();

        //Use Typed query to log persisted models
        TypedQuery<Model> tq = em1.createQuery("select distinct m from Model m", Model.class);
        List<Model> results = tq.getResultList();
        results.forEach(model -> log.info("Typed Query Result model: " + model.getName()));


        airportRepository.save(Airport.builder()
                                      .name("Walesa Airport")
                                      .description("NICE AIRPORT IN CITY OF GDAŃSK")
                                      .planes(planes)
                                      .build());

        log.info("DBManipulationEnd");
    }
}
