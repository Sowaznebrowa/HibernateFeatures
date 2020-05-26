package com.sowa.test.spring.jpa.hibernate.demo.repository;

import com.sowa.test.spring.jpa.hibernate.demo.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaneRepository extends JpaRepository<Plane, Long> {

    @Query("SELECT p FROM Plane p WHERE LOWER(p.description) = LOWER(:desc)")
    Plane retrievePlaneByDescription(@Param("desc") String description);
}
