package com.paytm.singleton.util;

import com.paytm.singleton.configuration.FileConfSingleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

public class CustomLoggerSingleton {
    private BufferedWriter bufferedWriter;
    public static enum FLAG{
        INFO("INFO : "),
        DEBUG("DEBUG : "),
        ERROR("ERROR : ");

        private String outputString;
        FLAG(String str) {
            outputString = str;
        }

        public String getOutputString() {
            return outputString;
        }
    }

    private static CustomLoggerSingleton logger = null;

    private CustomLoggerSingleton(FileConfSingleton conf) {
        try {
            FileWriter fObj = new FileWriter(conf.getBaseAddress() + conf.getFileName(), false);
            bufferedWriter = new BufferedWriter(fObj);
        } catch(Exception e) {
            e.printStackTrace();
            bufferedWriter = null;
        }
    }

    public static CustomLoggerSingleton getInstance(FileConfSingleton conf) {
        if (logger == null)
            logger = new CustomLoggerSingleton(conf);
        return logger;
    }

    public void log(CustomLoggerSingleton.FLAG flag, String writeString) throws java.io.IOException {
        Date currDate = new Date();

        bufferedWriter.write(currDate + " " + flag.getOutputString() + writeString + "\n");
        bufferedWriter.flush();
    }
}
