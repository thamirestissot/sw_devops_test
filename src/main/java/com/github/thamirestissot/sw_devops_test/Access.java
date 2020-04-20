package com.github.thamirestissot.sw_devops_test;

public class Access {

    private String url;
    private String date;
    private String uuid;
    private String regionCode;

    public Access(String url, String date, String uuid, String regionCode) {
        this.url = url;
        this.date = date;
        this.uuid = uuid;
        this.regionCode = regionCode;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getRegionCode() {
        return regionCode;
    }
}