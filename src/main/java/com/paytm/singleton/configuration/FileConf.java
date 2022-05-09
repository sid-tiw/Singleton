package com.paytm.singleton.configuration;

public class FileConf {
    private String fileName;
    private String baseAddress;
    
    public FileConf(String fileName, String baseAddress) {
        this.fileName = fileName;
        this.baseAddress = baseAddress;
    }

    public String getFileName() {
        return fileName;
    }
    
    public String getBaseAddress() {
        return baseAddress;
    }
}
