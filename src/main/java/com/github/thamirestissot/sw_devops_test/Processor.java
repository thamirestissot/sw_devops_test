package com.github.thamirestissot.sw_devops_test;

import com.github.thamirestissot.sw_devops_test.service.DataRefiner;

import java.sql.Timestamp;
import java.util.List;

public class Processor {
    private SettingsReader settingsReader;
    private DAO database;

    public void record(String rawData) {
        settingsReader = new SettingsReader();

        List<Access> accesses = DataRefiner.refineData(rawData);
        database = new DAO (settingsReader.getDbURL(), settingsReader.getDbUser(), settingsReader.getDbPassword());

        accesses.forEach(access -> database.insert(settingsReader.getDbName(), settingsReader.getDbMeasurements(), access));
    }
}
