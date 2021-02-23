package com.mostainahmed.discoverkhulna.website;

public class Web {
    int webImage;
    String webUrl;
    String webName;
    String webDescription;

    public int getWebImage() {
        return webImage;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getWebName() {
        return webName;
    }

    public String getWebDescription() {
        return webDescription;
    }

    public Web(int webImage, String webUrl, String webName, String webDescription) {
        this.webImage = webImage;
        this.webUrl = webUrl;
        this.webName = webName;
        this.webDescription = webDescription;
    }
}
