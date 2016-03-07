package com.synthapp.embeddedproject.repo;

import com.synthapp.embeddedproject.AppConfig;
import com.synthapp.embeddedproject.RestConfig;
import org.springframework.context.annotation.Import;

@Import(value = {AppConfig.class, RestConfig.class})
public class TestConfig {
    
}
