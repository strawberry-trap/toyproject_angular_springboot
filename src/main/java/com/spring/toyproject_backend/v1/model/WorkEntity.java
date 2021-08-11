package com.spring.toyproject_backend.v1.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WorkEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<UserEntity> relatedUsers = new HashSet<UserEntity>();

    @Column(name="name")
    private String name;

    @Column(name="pay")
    private Long pay;

    @Column(name="description")
    private String description;

    @Column(name="dueDate")
    private Date dueDate;

    public WorkEntity() {}

    public WorkEntity(String name, Long pay, String description, Date dueDate) {
        this.name = name;
        this.pay = pay;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPay() {
        return pay;
    }

    public void setPay(Long pay) {
        this.pay = pay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
