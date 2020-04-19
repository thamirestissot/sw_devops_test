package com.github.thamirestissot.sw_devops_test;

import java.sql.Timestamp;

public class Service {
    private SettingsReader settingsReader;
    private DAO dao;
    public void record(String str) {
        System.out.println( new Timestamp(System.currentTimeMillis()).getTime());
    }
}
