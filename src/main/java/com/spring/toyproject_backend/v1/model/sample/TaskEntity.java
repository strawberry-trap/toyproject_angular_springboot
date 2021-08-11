package com.spring.toyproject_backend.v1.model.sample;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="task")
public class TaskEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL
    private Long id;

    @Column(name="type")
    @NotNull
    private String type;

    public TaskEntity () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
