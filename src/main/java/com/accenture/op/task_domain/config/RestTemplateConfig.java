package com.accenture.op.task_domain.config;

import com.accenture.op.task_domain.services.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
//    @Bean
//    @Qualifier("asdaw")
//    public ProjectMapper asdad(){
//        return
//    }
}
