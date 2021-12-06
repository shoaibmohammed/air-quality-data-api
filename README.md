###Air Quality Data Api

####Setup
- Install Java 17.
- Download or Clone the project from Github. (then unzip if downloaded)
- https://github.com/shoaibmohammed/air-quality-data-api

####Option 1 - In IDE
- Open a new Maven project in an IDE like Intellij or Eclipse.
- In Intellij - File -> New -> Project From Existing Sources -> choose the pom.xml file in the downloaded directory.
- Then open AirQualityDataApiApp.java file in src/main/java/com/shoaib/airqualitydataapi package.
- Then right click in the file and select "Run".
- To test if application is running open this url in browser localhost:8080 , if a page with text 'Air Quality Data' opens up, the app is running.

####Option 2 - In Terminal
In the project home directory run the following maven commands
- mvn clean install    - (build application, run unit tests)
- mvn spring-boot:run  - (run the application)
- To test if application is running open this url in browser localhost:8080 , if a page with text 'Air Quality Data' opens up, the app is running.


####Endpoints

POST - localhost:8080/data/v1/airqualitydata/

Sample Payload

    {
        "groundLevelOzone": 0.811,
        "twoPointFivePM": 399.1,
        "tenPM": 100.0,
        "carbonMonoxide": 41.2,
        "sulfurDioxide": 214.0,
        "nitrogenDioxide": 412.0
    }

Some or all the values can be missing or they can be null (faulty sensor scenario)

To Retrive all the stored records

GET - localhost:8080/data/v1/airqualitydata/

To Enter a random set of air quality data (simulating readings from sensors)

GET - localhost:8080/data/v1/airqualitydata/random


####Notes
Use an API client like postman to call the Rest endpoints, a postman collection is available in postman folder with all api calls.

Screenshots of output are in screenshots folder.


####Assumptions

- User enters data points in the specified units


     {
      Ground-level ozone (O3)        -   ppm
      Particulate matter 2.5 (PM2.5) -   μg/m3
      Particulate matter 10 (PM10)   -   μg/m3
      Carbon monoxide (CO)           -   ppm
      Sulfur dioxide (SO2)           -   ppb
      Nitrogen dioxide (NO2)         -   ppb
     }

