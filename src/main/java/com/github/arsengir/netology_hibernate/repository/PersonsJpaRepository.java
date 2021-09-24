package com.github.arsengir.netology_hibernate.repository;

import com.github.arsengir.netology_hibernate.repository.entity.Persons;
import com.github.arsengir.netology_hibernate.repository.entity.PersonsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonsJpaRepository extends JpaRepository<Persons, PersonsId> {

    @Query(value = "select p from Persons p where p.city = :city")
    List<Persons> findByCity(@Param("city") String City);

    @Query(value = "select p from Persons p where p.personsId.age < :age order by p.personsId.age")
    List<Persons> findByPersonsId_AgeLessThanOrderByPersonsIdAge(@Param("age") int PersonsIdAge);

    @Query(value = "select * from netology.persons p where p.name = ? and p.surname = ? limit 1", nativeQuery = true)
    Optional<Persons> findFirstByPersonsId_NameAndPersonsId_Surname(String name, String surname);
}
