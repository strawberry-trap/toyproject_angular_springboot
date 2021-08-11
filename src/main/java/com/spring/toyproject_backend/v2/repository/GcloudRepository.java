package com.spring.toyproject_backend.v2.repository;

import com.spring.toyproject_backend.v2.domain.GcloudEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GcloudRepository extends JpaRepository<GcloudEntity, Long> {

    @Query(
            "select gcloudEntity \n"+
                    " from GcloudEntity as gcloudEntity \n"+
                    "where gcloudEntity.name like :searchName \n"

    )
    Page<GcloudEntity> getGcloudEntityList(@Param("searchName") String searchName, Pageable pageable);

}
