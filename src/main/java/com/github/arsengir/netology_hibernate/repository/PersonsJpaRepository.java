package com.github.arsengir.netology_hibernate.repository;

import com.github.arsengir.netology_hibernate.repository.entity.Persons;
import com.github.arsengir.netology_hibernate.repository.entity.PersonsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonsJpaRepository extends JpaRepository<Persons, PersonsId> {

    List<Persons> findByCity(String City);

    List<Persons> findByPersonsId_AgeLessThanOrderByPersonsIdAge(int PersonsIdAge);

    Optional<Persons> findFirstByPersonsId_NameAndPersonsId_Surname(String name, String surname);
}
