package com.github.arsengir.netology_hibernate.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Persons implements Serializable {

    @EmbeddedId
    private PersonsId personsId;

    private String phone_number;

    @Column(name = "city_of_living")
    private String city;

}
