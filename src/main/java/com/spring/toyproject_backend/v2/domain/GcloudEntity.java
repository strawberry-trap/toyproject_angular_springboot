package com.spring.toyproject_backend.v2.domain;

import javax.persistence.*;

@Entity
@Table(name="T_GCLOUD")
public class GcloudEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="gcloud_name")
    private String name;

    @Column(name="gcloud_info")
    private String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
