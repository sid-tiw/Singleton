package com.paytm.singleton.service;

import com.paytm.singleton.util.CustomLoggerNotSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class WriteDetails {
    final CustomLoggerNotSingleton logger;

    public WriteDetails(CustomLoggerNotSingleton logger) {
        this.logger = logger;
    }

    public void setDetails(String accountNumber) throws java.io.IOException {
        // worst possible practice of logging.
        logger.log(CustomLoggerNotSingleton.FLAG.INFO, accountNumber + " set his details.");
    }

    public void getAccountNumber(String name) throws java.io.IOException {
        if (name != null) {
            // Worst possible practice of logging.
            logger.log(CustomLoggerNotSingleton.FLAG.INFO, name + " wanted to set his/her account number.");
        } else {
            logger.log(CustomLoggerNotSingleton.FLAG.ERROR, "nullPointerException in setAccountNumber");
        }
    }
}
