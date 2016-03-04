package com.synthapp.embeddedproject.com.repo;

import com.synthapp.embeddedproject.com.domain.ProductCategory;
import com.synthapp.embeddedproject.com.domain.ProductCategoryNotBiDirectional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


@RepositoryRestResource(collectionResourceRel = "productCategoryNoBiDir", path = "productCategoryNoBiDir", exported = false)
public interface ProductCategoryNotBiDirectionalRepository extends JpaRepository<ProductCategoryNotBiDirectional, Long>, JpaSpecificationExecutor<ProductCategoryNotBiDirectional> {    
    ProductCategoryNotBiDirectional findById(@Param("id") Long id);
    List<ProductCategoryNotBiDirectional> findByName(@Param("name") String name);
}