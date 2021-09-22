package com.github.arsengir.netology_hibernate;

import com.github.arsengir.netology_hibernate.repository.entity.Persons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class NetologyHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetologyHibernateApplication.class, args);
    }

}
