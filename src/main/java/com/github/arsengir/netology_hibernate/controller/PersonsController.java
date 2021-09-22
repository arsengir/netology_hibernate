package com.github.arsengir.netology_hibernate.controller;

import com.github.arsengir.netology_hibernate.repository.entity.Persons;
import com.github.arsengir.netology_hibernate.service.PersonsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsController {

    private final PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city){
        return personsService.getPersonsByCity(city);
    }

    @GetMapping("/persons/init")
    public String initPersons() {
        return personsService.initPersons();
    }
}
