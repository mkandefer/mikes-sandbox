package com.synthapp.embeddedproject.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "store")
@EqualsAndHashCode(exclude="categories", callSuper = true)
@ToString(exclude="categories", callSuper = true)
public class Store extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = ProductCategory.class, cascade = CascadeType.ALL, mappedBy = "store")
    @Getter
    private List<ProductCategory> categories = new ArrayList<>();

    public void setCategories(List<ProductCategory> categories) {
        for (ProductCategory category : categories) {
            if (category.getStore() == null || !category.getStore().equals(this)) {
                category.setStore(this);
            }
        }
        this.categories = categories;

    }
    
}
