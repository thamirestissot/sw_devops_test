package com.github.thamirestissot.sw_devops_test;

public class Access {

    private String url;
    private Long date;
    private String uuid;
    private String regionCode;

    public Access(String url, Long date, String uuid, String regionCode) {
        this.url = url;
        this.date = date;
        this.uuid = uuid;
        this.regionCode = regionCode;
    }

    public String getUrl() {
        return url;
    }

    public Long getDate() {
        return date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getRegionCode() {
        return regionCode;
    }
}