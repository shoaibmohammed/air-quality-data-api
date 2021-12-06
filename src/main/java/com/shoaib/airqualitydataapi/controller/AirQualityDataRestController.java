package com.shoaib.airqualitydataapi.controller;

import com.shoaib.airqualitydataapi.entity.AirQualityData;
import com.shoaib.airqualitydataapi.exception.DataNotFoundException;
import com.shoaib.airqualitydataapi.exception.InvalidDataException;
import com.shoaib.airqualitydataapi.service.AirQualityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/data/v1/airqualitydata")
@RestController
public class AirQualityDataRestController {

    @Autowired
    AirQualityDataService airQualityDataService;

    @RequestMapping(value = {"/{id}", "/{id}/" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirQualityData> getDataById(@PathVariable("id") long id) {

        AirQualityData airQualityData;
        try {
            airQualityData = airQualityDataService.getById(id);
        } catch (Exception e) {
            throw new DataNotFoundException();
        }

        return new ResponseEntity<>(airQualityData, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<AirQualityData> add(@RequestBody AirQualityData airQualityData) {

        try{
            airQualityDataService.save(airQualityData);
        } catch (Exception e) {
            throw new InvalidDataException();
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirQualityData>> getData() {

        return new ResponseEntity<>(airQualityDataService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/random", "/random/"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AirQualityData> addRandom() {

        airQualityDataService.saveRandom();

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
