package com.synthapp.embeddedproject;


import java.nio.charset.Charset;
import java.util.Set;

import javax.persistence.Entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestConfig extends RepositoryRestMvcConfiguration {

    private static final Logger log = LogManager.getLogger();

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        try {
            Reflections reflections = new Reflections("com.synthapp.embeddedproject.domain");
            Set<Class<?>> idExposedClasses = reflections.getTypesAnnotatedWith(Entity.class, false);
            config.setReturnBodyOnCreate(true)
                    .setReturnBodyOnUpdate(false)
                    .exposeIdsFor(idExposedClasses.toArray(new Class[idExposedClasses.size()])).setDefaultMediaType(new org.springframework.http.MediaType("application", "json", Charset.defaultCharset()));
            config.setBasePath("/synthapp/api");

            config.getMetadataConfiguration().setAlpsEnabled(false);

        } catch (Exception ex) {
            log.error("Error configuring rest", ex);
        }
    }

}
