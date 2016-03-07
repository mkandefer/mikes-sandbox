package com.synthapp.embeddedproject.domain.projections;

import com.synthapp.embeddedproject.domain.ProductCategoryNotBiDirectional;
import com.synthapp.embeddedproject.domain.StoreNotBiDirectional;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineCategoriesNoBiDir", types = {StoreNotBiDirectional.class})
public interface InlineCategoriesNoBiDir {

    Long getId();
    String getName();

    List<ProductCategoryNotBiDirectional> getCategories();

}
