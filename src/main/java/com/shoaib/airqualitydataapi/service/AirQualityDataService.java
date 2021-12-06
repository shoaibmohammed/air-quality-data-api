package com.shoaib.airqualitydataapi.service;

import com.shoaib.airqualitydataapi.entity.AirQualityData;
import com.shoaib.airqualitydataapi.exception.InvalidDataException;
import com.shoaib.airqualitydataapi.repository.AirQualityDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.Objects.isNull;

@Service
public class AirQualityDataService {

    @Autowired
    AirQualityDataRepository airQualityDataRepository;

    private static final AtomicLong idCounter = new AtomicLong();

    private static final DecimalFormat oneDecimal = new DecimalFormat("0.0");
    private static final DecimalFormat threeDecimal = new DecimalFormat("0.000");


    private static final Double MAX_GROUND_LEVEL_OZONE_LEVEL = 0.604;
    private static final Double MAX_TWO_POINT_FIVE_PM_LEVEL = 500.4;
    private static final Double MAX_TEN_PM_LEVEL = 0.604;
    private static final Double MAX_CARBON_MONOXIDE_LEVEL = 50.4;
    private static final Double MAX_SULFUR_DIOXIDE_OZONE = 1004.0;
    private static final Double MAX_NITROGEN_DIOXIDE_OZONE = 2049.0;

    public long generateId()
    {
        return idCounter.getAndIncrement();
    }

    public void save(AirQualityData airQualityData) {
        if (validate(airQualityData) ) {
            airQualityData.setId(generateId());
            airQualityDataRepository.save(airQualityData);
        } else {
            throw new InvalidDataException();
        }
    }

    private boolean validate(AirQualityData airQualityData) {
        if (!(isNull(airQualityData.getGroundLevelOzone()) || (airQualityData.getGroundLevelOzone() > 0 && airQualityData.getGroundLevelOzone() < MAX_GROUND_LEVEL_OZONE_LEVEL))) {
            return false;
        }
        else if (!(isNull(airQualityData.getTwoPointFivePM()) || (airQualityData.getTwoPointFivePM() > 0 && airQualityData.getGroundLevelOzone() < MAX_TWO_POINT_FIVE_PM_LEVEL))) {
            return false;
        }
        else if (!(isNull(airQualityData.getTenPM()) || (airQualityData.getTenPM() > 0 && airQualityData.getGroundLevelOzone() < MAX_TEN_PM_LEVEL))) {
            return false;
        }
        else if (!(isNull(airQualityData.getCarbonMonoxide()) || (airQualityData.getCarbonMonoxide() > 0 && airQualityData.getGroundLevelOzone() < MAX_CARBON_MONOXIDE_LEVEL))) {
            return false;
        }
        else if (!(isNull(airQualityData.getSulfurDioxide()) || (airQualityData.getSulfurDioxide() > 0 && airQualityData.getGroundLevelOzone() < MAX_SULFUR_DIOXIDE_OZONE))) {
            return false;
        }
        else if (!(isNull(airQualityData.getNitrogenDioxide()) || (airQualityData.getNitrogenDioxide() > 0 && airQualityData.getGroundLevelOzone() < MAX_NITROGEN_DIOXIDE_OZONE))) {
            return false;
        }
            return true;
    }

    public AirQualityData getById(long id) {

        return airQualityDataRepository.getById(id);
    }

    public List<AirQualityData> findAll() {
        return airQualityDataRepository.findAll();
    }

    public void saveRandom() {
        AirQualityData randomAirQualityData = new AirQualityData(
            Double.parseDouble(threeDecimal.format(Math.random() * MAX_GROUND_LEVEL_OZONE_LEVEL)),
            Double.parseDouble(oneDecimal.format(Math.random() * MAX_TWO_POINT_FIVE_PM_LEVEL)),
            Double.parseDouble(threeDecimal.format(Math.random() * MAX_TEN_PM_LEVEL)),
            Double.parseDouble(oneDecimal.format(Math.random() * MAX_CARBON_MONOXIDE_LEVEL)),
            Double.parseDouble(oneDecimal.format(Math.random() * MAX_SULFUR_DIOXIDE_OZONE)),
            Double.parseDouble(oneDecimal.format(Math.random() * MAX_NITROGEN_DIOXIDE_OZONE))
        );

        randomAirQualityData.setId(generateId());
        airQualityDataRepository.save(randomAirQualityData);
    }
}
