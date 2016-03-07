package com.synthapp.embeddedproject.repo;

import com.synthapp.embeddedproject.domain.Store;
import com.synthapp.embeddedproject.domain.projections.InlineCategories;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


@RepositoryRestResource(collectionResourceRel = "store", path = "store")
public interface StoreRepository extends JpaRepository<Store, Long>, JpaSpecificationExecutor<Store> {
    
    Store findById(@Param("id") Long id);
    Optional<Store> findFirstByName(@Param("name") String name);
}