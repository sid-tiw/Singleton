package com.paytm.singleton.configuration;

public class FileConfSingleton {
    private String fileName;
    private String baseAddress;

    public FileConfSingleton(String fileName, String baseAddress) {
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
