package com.github.thamirestissot.sw_devops_test.dao;

import com.github.thamirestissot.sw_devops_test.Access;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.concurrent.TimeUnit;

public class Database {
    private InfluxDB influxDB;

    public Database(String databaseURL, String userName, String password) {
        this.influxDB = InfluxDBFactory.connect(databaseURL, userName, password);
    }

    public void insert(String databaseName, String measurements, Access access) {
        BatchPoints batchPoints = BatchPoints.database(databaseName).build();

        Point point = Point
                .measurement(measurements)
                .time(Long.parseLong(access.getDate()), TimeUnit.MILLISECONDS)
                .tag("url", access.getUrl())
                .addField("uuid", access.getUuid())
                .addField("regionCode", access.getRegionCode())
                .build();

        batchPoints.point(point);
        influxDB.write(batchPoints);
    }

    public String getTop3UrlAccessed(String databaseName, String measurement) {
        influxDB.setDatabase(databaseName);
        QueryResult queryResult = influxDB.query(new Query("SELECT * FROM "+measurement));
        System.out.println(queryResult);
        return null;
    }
}
