package com.Ducat.SpringFirstProject.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 

@Configuration
public class Config {
    @Bean
    public ModelMapper getModelMapperBean(){
        return new ModelMapper();
    }
}
