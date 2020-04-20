package com.github.thamirestissot.sw_devops_test.service;

import com.github.thamirestissot.sw_devops_test.Access;

import java.util.ArrayList;
import java.util.List;

public class DataRefiner {
    public static List<Access> refineData(String rawData) {
        String[] rowData = rawData.split("\n");
        String[] data;
        List<Access> accesses = new ArrayList<>();
        Access access;
        for (String rawRow : rowData) {
            data = rawRow.split(" ");
            accesses.add(new Access(data[0], data[1], data[2], data[3]));
        }
        return accesses;
    }

}
