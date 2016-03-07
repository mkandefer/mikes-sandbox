/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synthapp.embeddedproject.domain.projections;

import com.synthapp.embeddedproject.domain.ProductCategory;
import com.synthapp.embeddedproject.domain.Store;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author djustinger
 */
@Projection(name = "inlineCategories", types = {Store.class})
public interface InlineCategories {

    Long getId();
    String getName();

    List<ProductCategory> getCategories();

}
