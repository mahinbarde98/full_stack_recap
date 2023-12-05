package com.stackroute.swaggerautoconfbean.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class CustomDataSourceConfig {
    //Define a custom data source bean called 'dataSource' of type 'CustomDataSource', and marks it as the primary candidate


    @Primary
    public CustomDataSource dataSource(){
        return new CustomDataSource();
    }
}
