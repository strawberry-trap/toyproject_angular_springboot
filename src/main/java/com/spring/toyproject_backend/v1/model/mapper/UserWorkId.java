package com.spring.toyproject_backend.v1.model.mapper;

import com.spring.toyproject_backend.v1.model.UserEntity;
import com.spring.toyproject_backend.v1.model.WorkEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class UserWorkId implements Serializable {

    private UserEntity userId;

    private WorkEntity workId;

    public UserWorkId() { }

    public UserWorkId(UserEntity userId, WorkEntity workId) {
        this.userId = userId;
        this.workId = workId;
    }

    // auto-generated hashCode & equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWorkId that = (UserWorkId) o;
        return userId.equals(that.userId) && workId.equals(that.workId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, workId);
    }
}
