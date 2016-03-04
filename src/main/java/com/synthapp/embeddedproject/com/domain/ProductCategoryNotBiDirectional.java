package com.synthapp.embeddedproject.com.domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "product_category")
@EqualsAndHashCode(exclude={"store", "children", "parent"}, callSuper = true)
@ToString(exclude={"store", "children", "parent"}, callSuper = true)
public class ProductCategoryNotBiDirectional extends BaseEntity {
    
    @Getter @Setter
    @Column(name="name")
    private String name;
    
    @Getter @Setter
    @Column(name="store_id", nullable = true)
    private Long storeId;
    
   
    @Getter @Setter
    @Column(name = "parent", nullable = true)
    private Long parentId;
    
    @OneToMany(targetEntity = ProductCategoryNotBiDirectional.class, cascade=CascadeType.ALL)
    @JoinColumn(name="parent", referencedColumnName="id")
    @Getter @Setter
    @RestResource(rel = "children", path = "children")
    private List<ProductCategoryNotBiDirectional> children = new ArrayList<>();
}
