package com.sowa.test.spring.jpa.hibernate.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    Long id;

    @Column(name="DESCRIPTION")
    String description;

    @OneToMany(fetch = FetchType.EAGER)
    List<Plane> planes;

    @Column(name = "NAME", nullable = false)
    String name;
}
