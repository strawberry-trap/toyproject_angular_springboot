package com.spring.toyproject_backend.v1.model.dto;

import com.spring.toyproject_backend.v1.model.UserEntity;
import lombok.Builder;

import java.util.Date;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private Date regDate;
    private Date modDate;

    // builder for converting Entity => Dto
    @Builder
    public UserDto (Long id, String firstName, String lastName, String email, Date regDate, Date modDate) {
        super();

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.regDate = regDate;
        this.modDate = modDate;
    }

    // converting Dto => Entity
    public UserEntity toEntity() {

        UserEntity user = new UserEntity();

        user.setId(this.id);
        user.setLastName(this.lastName);
        user.setFirstName(this.firstName);
        user.setEmail(this.email);

        return user;
    }

    // getters, setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }
}
