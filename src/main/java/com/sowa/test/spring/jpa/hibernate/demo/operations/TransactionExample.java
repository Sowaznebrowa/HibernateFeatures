package com.sowa.test.spring.jpa.hibernate.demo.operations;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;


@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class TransactionExample {

    private final EntityManagerFactory entityManagerFactory;

    public TransactionExample(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void updatePlanesDescriptionsInTransaction(){

    }
}
