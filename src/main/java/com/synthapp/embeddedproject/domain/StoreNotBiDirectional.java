package com.synthapp.embeddedproject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "store")
@EqualsAndHashCode(exclude="categories", callSuper = true)
@ToString(exclude="categories", callSuper = true)
public class StoreNotBiDirectional extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = ProductCategoryNotBiDirectional.class, cascade = CascadeType.ALL)
    @JoinColumn(name="store_id", referencedColumnName="id")
    @Getter @Setter
    private List<ProductCategoryNotBiDirectional> categories = new ArrayList<>(); 
}
