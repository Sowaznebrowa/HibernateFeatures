package com.sowa.test.spring.jpa.hibernate.demo.repository;

import com.sowa.test.spring.jpa.hibernate.demo.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findModelByName(String name);
}
