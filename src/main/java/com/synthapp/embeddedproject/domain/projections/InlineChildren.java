package com.synthapp.embeddedproject.domain.projections;

import com.synthapp.embeddedproject.domain.ProductCategory;
import com.synthapp.embeddedproject.domain.ProductCategoryNotBiDirectional;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineChildren", types = {ProductCategory.class})
public interface InlineChildren {

    Long getId();
    String getName();

    List<ProductCategory> getChildren();

}
