package com.github.arsengir.netology_hibernate.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Persons implements Serializable {

    @Id
    private String name;

    @Id
    private String surname;

    @Id
    private int age;

    private String phone_number;

    private String city_of_living;

}
