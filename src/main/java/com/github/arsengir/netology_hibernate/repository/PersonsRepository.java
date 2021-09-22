package com.github.arsengir.netology_hibernate.repository;

import com.github.arsengir.netology_hibernate.repository.entity.Persons;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
public class PersonsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void initPersons() {
        List<String> names = List.of("Andrey", "Pavel", "Vlad");
        List<String> surNames = List.of("Petrov", "Ivanov", "Sidorov");
        List<String> cites = List.of("Moscow", "London", "New York");

        Random random = new Random();
        IntStream.range(0, 10)
                .forEach(i -> {
                    var person = Persons.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surNames.get(random.nextInt(surNames.size())))
                            .age(random.nextInt(100))
                            .city_of_living(cites.get(random.nextInt(cites.size())))
                            .build();
                    entityManager.persist(person);
                });
    }

    public List<Persons> getPersonsByCity(String city) {
        TypedQuery<Persons> query = entityManager.createQuery("select p from Persons p where p.city_of_living = :city", Persons.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

}
