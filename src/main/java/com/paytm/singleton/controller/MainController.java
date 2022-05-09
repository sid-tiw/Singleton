package com.paytm.singleton.controller;

import com.paytm.singleton.configuration.FileConf;
import com.paytm.singleton.service.FetchDetails;
import com.paytm.singleton.service.FetchDetailsSingleton;
import com.paytm.singleton.service.WriteDetails;
import com.paytm.singleton.service.WriteDetailsSingleton;
import com.paytm.singleton.util.CustomLoggerNotSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    Environment environment;

    @Autowired
    WriteDetailsSingleton writeDetailsSingleton;

    @Autowired
    FetchDetailsSingleton fetchDetailsSingleton;

    @GetMapping("/fetch/{accountNumber}")
    public ResponseEntity<String> getDetails(@PathVariable String accountNumber) {
        try {
            FetchDetails fetchDetails = new FetchDetails(new CustomLoggerNotSingleton(new FileConf(environment.getProperty("logging.fileName"), environment.getProperty("logging.baseAddress"))));
            String output = fetchDetails.getDetails(accountNumber);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }

    @GetMapping("/write/{accountNumber}")
    public ResponseEntity<String> setDetails(@PathVariable String accountNumber) {
        try {
            WriteDetails writeDetails = new WriteDetails(new CustomLoggerNotSingleton(new FileConf(environment.getProperty("logging.fileName"), environment.getProperty("logging.baseAddress"))));
            writeDetails.setDetails(accountNumber);
            return ResponseEntity.ok("Successfully set the details.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }

    @GetMapping("/singleton/fetch/{accountNumber}")
    public ResponseEntity<String> getDetailsSingleton(@PathVariable String accountNumber) {
        try {
            String output = fetchDetailsSingleton.getDetails(accountNumber);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }

    @GetMapping("/singleton/write/{accountNumber}")
    public ResponseEntity<String> setDetailsSingleton(@PathVariable String accountNumber) {
        try {
            writeDetailsSingleton.setDetails(accountNumber);
            return ResponseEntity.ok("Successfully set the details.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }
}
