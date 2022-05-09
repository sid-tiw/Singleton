package com.paytm.singleton.service;

import com.paytm.singleton.util.CustomLoggerSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteDetailsSingleton {
    @Autowired
    CustomLoggerSingleton logger;

    public void setDetails(String accountNumber) throws java.io.IOException {
        // worst possible practice of logging.
        logger.log(CustomLoggerSingleton.FLAG.INFO, accountNumber + " set his details.");
    }

    public void getAccountNumber(String name) throws java.io.IOException {
        if (name != null) {
            // Worst possible practice of logging.
            logger.log(CustomLoggerSingleton.FLAG.INFO, name + " wanted to set his/her account number.");
        } else {
            logger.log(CustomLoggerSingleton.FLAG.ERROR, "nullPointerException in setAccountNumber");
        }
    }
}
