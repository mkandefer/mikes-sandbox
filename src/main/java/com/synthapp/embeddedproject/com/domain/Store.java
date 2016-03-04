package com.synthapp.embeddedproject.com.domain;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.rest.core.annotation.RestResource;


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
    @JsonManagedReference
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
