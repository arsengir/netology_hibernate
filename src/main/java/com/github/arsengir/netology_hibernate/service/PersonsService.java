package com.github.arsengir.netology_hibernate.service;

import com.github.arsengir.netology_hibernate.repository.PersonsRepository;
import com.github.arsengir.netology_hibernate.repository.entity.Persons;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsService {
    private final PersonsRepository personsRepository;

    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    public List<Persons> getPersonsByCity(String city) {
        return personsRepository.getPersonsByCity(city);
    }

    public List<Persons> getPersonsLessAge(int age){
        return personsRepository.getPersonsLessAge(age);
    }

    public Optional<Persons> getPersonsNameSurname(String name, String surname) {
        return personsRepository.getPersonsNameSurname(name, surname);
    }

    public String initPersons() {
        personsRepository.initPersons();
        return "Ok";
    }
}
