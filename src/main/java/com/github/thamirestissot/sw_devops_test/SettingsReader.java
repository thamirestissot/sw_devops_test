package com.github.thamirestissot.sw_devops_test;

import com.github.thamirestissot.sw_devops_test.exceptions.CannotReadConfigurationFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsReader {

    private String dbURL;
    private String dbUser;
    private String dbPassword;
    private String dbName;
    private String dbMeasurements;

    public SettingsReader() {

        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);
            dbURL = properties.getProperty("db.URL");
            dbUser = properties.getProperty("db.username");
            dbPassword = properties.getProperty("db.password");
            dbName = properties.getProperty("db.name");
            dbMeasurements = properties.getProperty("db.measurements");

        } catch (IOException e) {
            throw new CannotReadConfigurationFileException();
        }
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbMeasurements() {
        return dbMeasurements;
    }
}
