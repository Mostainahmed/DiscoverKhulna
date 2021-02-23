package com.mostainahmed.discoverkhulna.banks.nationalbank;

public class Bank {
    String bankName;
    String bankNumber;
    String bankAddress;
    String webUrl;
    int bankImage;

    public String getBankName() {
        return bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public int getBankImage() {
        return bankImage;
    }

    public Bank(String bankName, String bankNumber, String bankAddress, String webUrl, int bankImage) {
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.bankAddress = bankAddress;
        this.webUrl = webUrl;
        this.bankImage = bankImage;
    }
}

