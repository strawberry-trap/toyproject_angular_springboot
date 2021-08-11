package com.spring.toyproject_backend.v2.domain;

public class GcloudDto {

    private Long id;

    private String name;

    private String desc;

    public GcloudDto() {}

    public GcloudDto(GcloudEntity gcloudEntity) {
        this.id = gcloudEntity.getId();
        this.name = gcloudEntity.getName();
        this.desc = gcloudEntity.getDesc();
    }

    // getter, setter
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
