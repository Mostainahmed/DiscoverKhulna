package com.mostainahmed.discoverkhulna.banks.privatebank;

public class PrivateBank {
    String bankName;
    String bankWebUrl;
    int privateBankImage;

    public PrivateBank(String bankName, String bankWebUrl, int privateBankImage) {
        this.bankName = bankName;
        this.bankWebUrl = bankWebUrl;
        this.privateBankImage = privateBankImage;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankWebUrl() {
        return bankWebUrl;
    }

    public int getPrivateBankImage() {
        return privateBankImage;
    }
}
