package com.github.arsengir.netology_hibernate.repository;

import com.github.arsengir.netology_hibernate.repository.entity.Persons;
import com.github.arsengir.netology_hibernate.repository.entity.PersonsId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class PersonsRepository {

    private final PersonsJpaRepository personsJpaRepository;

    public PersonsRepository(PersonsJpaRepository personsJpaRepository) {
        this.personsJpaRepository = personsJpaRepository;
    }

    @Transactional
    public void initPersons() {
        List<String> names = List.of("Andrey", "Pavel", "Vlad");
        List<String> surNames = List.of("Petrov", "Ivanov", "Sidorov");
        List<String> cites = List.of("Moscow", "London", "New York");

        Random random = new Random();
        List<Persons> persons = IntStream.range(0, 10)
                .mapToObj(i -> Persons.builder()
                        .personsId(PersonsId.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surNames.get(random.nextInt(surNames.size())))
                                    .age(random.nextInt(100))
                                    .build())
                        .city(cites.get(random.nextInt(cites.size())))
                        .build())
                .collect(Collectors.toUnmodifiableList());

        personsJpaRepository.saveAll(persons);
    }

    public List<Persons> getPersonsByCity(String city) {
        return personsJpaRepository.findByCity(city);
    }

    public List<Persons> getPersonsLessAge(int age) {
        return personsJpaRepository.findByPersonsId_AgeLessThanOrderByPersonsIdAge(age);
    }

    public Optional<Persons> getPersonsNameSurname(String name, String surname) {
        return personsJpaRepository.findFirstByPersonsId_NameAndPersonsId_Surname(name, surname);
    }

}
