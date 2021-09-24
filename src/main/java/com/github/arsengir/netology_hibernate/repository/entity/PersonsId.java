package com.github.arsengir.netology_hibernate.repository.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class PersonsId implements Serializable {

    private String name;

    private String surname;

    private int age;
}
