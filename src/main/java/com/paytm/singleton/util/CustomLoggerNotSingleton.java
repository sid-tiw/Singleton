package com.paytm.singleton.util;

import com.paytm.singleton.configuration.FileConf;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

public class CustomLoggerNotSingleton {
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

    public CustomLoggerNotSingleton(FileConf conf) throws java.io.IOException {
        FileWriter fObj = new FileWriter(conf.getBaseAddress() + conf.getFileName(), false);
        bufferedWriter = new BufferedWriter(fObj);
    }

    public void log(String writeString) throws java.io.IOException {
        // by default write as an INFO log
        Date currDate = new Date();

        bufferedWriter.write(currDate + " " + FLAG.INFO.getOutputString() +
                writeString + "\n");
        bufferedWriter.flush();
    }

    public void log(FLAG flag, String writeString) throws java.io.IOException {
        Date currDate = new Date();

        bufferedWriter.write(currDate + " " + flag.getOutputString() + writeString + "\n");
        bufferedWriter.flush();
    }
}
