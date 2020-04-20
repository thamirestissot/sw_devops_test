package com.github.thamirestissot.sw_devops_test;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

public class DAO {
    private InfluxDB influxDB;

    public DAO(String databaseURL, String userName, String password) {
        this.influxDB = InfluxDBFactory.connect(databaseURL, userName, password);
    }

    public void insert(String name, String measurements, Access access) {
        BatchPoints batchPoints = BatchPoints.database(name).build();

        Point point = Point
                .measurement(measurements)
                .time(Long.parseLong(access.getDate()), TimeUnit.MILLISECONDS)
                .tag("url", String.valueOf(access.getUrl()))
                .addField("uuid", access.getUuid())
                .addField("regionCode", access.getRegionCode())
                .build();

        batchPoints.point(point);
        influxDB.write(batchPoints);
    }
}
