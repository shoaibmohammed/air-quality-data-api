package com.shoaib.airqualitydataapi.service;

import org.junit.Assert;
import org.junit.Test;

public class AirQualityDataServiceTest {

    AirQualityDataService airQualityDataService = new AirQualityDataService();

    @Test
    public void testGenerateId() {

        Assert.assertTrue(airQualityDataService.generateId() > -1);
    }

}