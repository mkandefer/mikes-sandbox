package com.synthapp.embeddedproject.com.repo;

import com.synthapp.embeddedproject.com.domain.Store;
import com.synthapp.embeddedproject.com.domain.StoreNotBiDirectional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


@RepositoryRestResource(collectionResourceRel = "storeNoBiDir", path = "storeNoBiDir")
public interface StoreNotBiDirectionalRepository extends JpaRepository<StoreNotBiDirectional, Long>, JpaSpecificationExecutor<StoreNotBiDirectional> {
    
    StoreNotBiDirectional findById(@Param("id") Long id);
    Optional<StoreNotBiDirectional> findFirstByName(@Param("name") String name);
}