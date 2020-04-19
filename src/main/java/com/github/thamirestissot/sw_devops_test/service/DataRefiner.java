package com.github.thamirestissot.sw_devops_test.service;

import com.github.thamirestissot.sw_devops_test.Access;

public class DataRefiner {
    static Access refine(String rawData) {
        String[] data = rawData.split(" ");
        return new Access(data[0], Long.parseLong(data[1]), data[2], data[3]);
    }
}
