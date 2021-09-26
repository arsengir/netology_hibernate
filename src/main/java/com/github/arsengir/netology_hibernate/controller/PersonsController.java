package com.github.arsengir.netology_hibernate.controller;

import com.github.arsengir.netology_hibernate.repository.entity.Persons;
import com.github.arsengir.netology_hibernate.service.PersonsService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonsController {

    private final PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city){
        return personsService.getPersonsByCity(city);
    }

    @GetMapping("/persons/less-age")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Persons> getPersonsLessAge(@RequestParam("age") int age){
        return personsService.getPersonsLessAge(age);
    }

    @GetMapping("/persons")
    @PostAuthorize("returnObject.get().personsId.name == authentication.principal.username")
    public Optional<Persons> getPersonsNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return personsService.getPersonsNameSurname(name, surname);
    }

    @GetMapping("/persons/init")
    @RolesAllowed("ROLE_WRITE")
    public String initPersons() {
        return personsService.initPersons();
    }
}
