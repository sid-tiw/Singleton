package com.paytm.singleton.service;

import com.paytm.singleton.util.CustomLoggerNotSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class FetchDetails {
    final CustomLoggerNotSingleton logger;

    public FetchDetails(CustomLoggerNotSingleton logger) {
        this.logger = logger;
    }

    public String getDetails(String accountNumber) throws java.io.IOException {
        // worst possible practice of logging.
        logger.log(CustomLoggerNotSingleton.FLAG.INFO, accountNumber + " accessed his details.");
        return "Siddhartha Tiwari; 7651895279;";
    }

    public String getAccountNumber(String name) throws java.io.IOException {
        if (name != null) {
            // Worst possible practice of logging.
            logger.log(CustomLoggerNotSingleton.FLAG.INFO, name + " wanted to know his/her account number.");
            return "7651895279";
        } else {
            logger.log(CustomLoggerNotSingleton.FLAG.ERROR, "nullPointerException in getAccountNumber");
            return null;
        }
    }
}
