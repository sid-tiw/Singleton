package com.paytm.singleton.service;

import com.paytm.singleton.util.CustomLoggerSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchDetailsSingleton {
    @Autowired
    CustomLoggerSingleton logger;

    public String getDetails(String accountNumber) throws java.io.IOException {
        // worst possible practice of logging.
        logger.log(CustomLoggerSingleton.FLAG.INFO, accountNumber + " accessed his details.");
        return "Siddhartha Tiwari; 7651895279;";
    }

    public String getAccountNumber(String name) throws java.io.IOException {
        if (name != null) {
            // Worst possible practice of logging.
            logger.log(CustomLoggerSingleton.FLAG.INFO, name + " wanted to know his/her account number.");
            return "7651895279";
        } else {
            logger.log(CustomLoggerSingleton.FLAG.ERROR, "nullPointerException in getAccountNumber");
            return null;
        }
    }
}
