package com.paytm.singleton.configuration;

import com.paytm.singleton.util.CustomLoggerNotSingleton;
import com.paytm.singleton.util.CustomLoggerSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class LoggerConfigurationBean {

    @Autowired
    FileConf fileConf;

    @Autowired
    FileConfSingleton fileConfSingleton;

    @Bean
    public CustomLoggerNotSingleton getCustomLoggerNotSingleton() {
        try {
            return new CustomLoggerNotSingleton(fileConf);
        } catch(java.io.IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Bean
    public CustomLoggerSingleton getCustomLoggerSingleton() {
        return CustomLoggerSingleton.getInstance(fileConfSingleton);
    }
}
