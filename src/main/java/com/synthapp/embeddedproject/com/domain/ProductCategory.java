package com.synthapp.embeddedproject.com.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "product_category")
@EqualsAndHashCode(exclude={"store", "children", "parent"}, callSuper = true)
@ToString(exclude={"store", "children", "parent"}, callSuper = true)
public class ProductCategory extends BaseEntity {
    
    @Getter @Setter
    @Column(name="name")
    private String name;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="store_id", nullable = true)
    @Getter
    @JsonIgnore
    @RestResource(exported = false)
    private Store store;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent", nullable = true)
    @Getter
    @JsonIgnore
    @RestResource(exported = false, path = "parent")
    private ProductCategory parent;
    
    @OneToMany(targetEntity = ProductCategory.class, cascade=CascadeType.ALL, mappedBy="parent")
    @Getter
    @RestResource(rel = "children", path = "children")
    private List<ProductCategory> children = new ArrayList<>();
    
    public void setStore(Store store) {
        this.store = store;
        if(!store.getCategories().contains(this)) {
            store.getCategories().add(this);
        }
    }
     
    public void setParent(ProductCategory parent) {
        this.parent = parent;
        if(!parent.getChildren().contains(this)) {
            parent.getChildren().add(this);
        }
    }
    
    public void setChildren(List<ProductCategory> children) {
        for(ProductCategory child : children) {
            if(child.getParent() == null || !child.getParent().equals(this)) {
                child.setParent(this);
            }
        }
        this.children = children;
    }
    
}
