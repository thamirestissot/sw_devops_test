package com.github.thamirestissot.sw_devops_test.service;

import com.github.thamirestissot.sw_devops_test.Access;
import com.github.thamirestissot.sw_devops_test.dao.Database;

import java.util.List;

public class Processor {
    private SettingsReader settingsReader;
    private Database database;

    public void record(String rawData) {
        settingsReader = new SettingsReader();

        List<Access> accesses = DataRefiner.refineData(rawData);
        database = new Database(settingsReader.getDbURL(), settingsReader.getDbUser(), settingsReader.getDbPassword());

        accesses.forEach(access -> database.insert(settingsReader.getDbName(), settingsReader.getDbMeasurements(), access));
    }
}
