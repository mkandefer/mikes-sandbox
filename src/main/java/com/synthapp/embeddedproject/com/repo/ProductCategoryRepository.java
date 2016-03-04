package com.synthapp.embeddedproject.com.repo;

import com.synthapp.embeddedproject.com.domain.ProductCategory;
import com.synthapp.embeddedproject.com.domain.Store;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;


@RepositoryRestResource(collectionResourceRel = "productCategory", path = "productCategory", exported = false)
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>, JpaSpecificationExecutor<ProductCategory> {    
    ProductCategory findById(@Param("id") Long id);
    List<ProductCategory> findByName(@Param("name") String name);
}