package com.spring.toyproject_backend.v1.model.mapper;

import com.spring.toyproject_backend.v1.model.UserEntity;
import com.spring.toyproject_backend.v1.model.WorkEntity;

import javax.persistence.*;

@Entity
@IdClass(UserWorkId.class)
public class UserWorkMapper {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="work_id")
    private WorkEntity workId;

    // extra information about this mapper
    // ...

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public WorkEntity getWorkId() {
        return workId;
    }

    public void setWorkId(WorkEntity workId) {
        this.workId = workId;
    }
}
