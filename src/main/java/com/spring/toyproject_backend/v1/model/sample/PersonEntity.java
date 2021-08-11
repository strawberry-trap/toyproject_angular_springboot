package com.spring.toyproject_backend.v1.model.sample;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="person")
public class PersonEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL
    private Long id;

    @Column(name = "person_name")
    @NotNull
    private String name;

    public PersonEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
