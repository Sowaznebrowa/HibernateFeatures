package com.sowa.test.spring.jpa.hibernate.demo.configuration;

import com.sowa.test.spring.jpa.hibernate.demo.repository.AirportRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

//@Configuration
//@EnableTransactionManagement
public class TransactionConfiguration implements TransactionManagementConfigurer {

    /*@Bean
    public FooRepository fooRepository() {
        // configure and return a class having @Transactional methods
        return new AirportRepository(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        // configure and return the necessary JDBC DataSource
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
*/
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return null;
    }
}
