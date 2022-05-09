package com.paytm.singleton.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class FileConfigurationBean {
    // Define a bean to get FileConf

    @Autowired
    Environment environment;

    @Bean
    public FileConf getFileConf() {
        String fileName = environment.getProperty("logging.fileName");
        String baseAddress = environment.getProperty("logging.baseAddress");

        return new FileConf(fileName, baseAddress);
    }

    @Bean
    public FileConfSingleton getFileConfSingleton() {
        String fileName = environment.getProperty("singleton.logging.fileName");
        String baseAddress = environment.getProperty("singleton.logging.baseAddress");

        return new FileConfSingleton(fileName, baseAddress);
    }
}
