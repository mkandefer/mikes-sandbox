package com.synthapp.embeddedproject.domain.projections;

import com.synthapp.embeddedproject.domain.ProductCategory;
import com.synthapp.embeddedproject.domain.Store;
import com.synthapp.embeddedproject.domain.StoreNotBiDirectional;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineCategories", types = {Store.class})
public interface InlineCategories {

    Long getId();
    String getName();

    List<ProductCategory> getCategories();

}
