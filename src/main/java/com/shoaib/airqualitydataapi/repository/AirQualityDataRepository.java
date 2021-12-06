package com.shoaib.airqualitydataapi.repository;

import com.shoaib.airqualitydataapi.entity.AirQualityData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AirQualityDataRepository {

    List<AirQualityData> airQualityDataList = new ArrayList<>();

    public void save(AirQualityData airQualityData) {
        airQualityDataList.add(airQualityData);
    }

    public AirQualityData getById(long id) {

        for (AirQualityData airQualityData : airQualityDataList) {
            if (airQualityData.getId() == id) {
                return airQualityData;
            }
        }
        return null;
    }

    public List<AirQualityData> findAll() {
        return airQualityDataList;
    }
}
