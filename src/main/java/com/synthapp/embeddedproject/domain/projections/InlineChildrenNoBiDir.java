package com.synthapp.embeddedproject.domain.projections;

import com.synthapp.embeddedproject.domain.ProductCategoryNotBiDirectional;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineChildrenNoBiDir", types = {ProductCategoryNotBiDirectional.class})
public interface InlineChildrenNoBiDir {

    Long getId();
    String getName();

    List<ProductCategoryNotBiDirectional> getChildren();

}
