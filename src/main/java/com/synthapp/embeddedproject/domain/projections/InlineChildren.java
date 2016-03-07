/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synthapp.embeddedproject.domain.projections;

import com.synthapp.embeddedproject.domain.ProductCategory;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author djustinger
 */
@Projection(name = "inlineChildren", types = {ProductCategory.class})
public interface InlineChildren {

    Long getId();
    String getName();

    List<ProductCategory> getChildren();

}
