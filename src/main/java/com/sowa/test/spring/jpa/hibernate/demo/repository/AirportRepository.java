package com.sowa.test.spring.jpa.hibernate.demo.repository;

import com.sowa.test.spring.jpa.hibernate.demo.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {
}
