package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.City;
import com.napier.sem.entities.CityJoinCountry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 13/03/2022 20:07
 * File Purpose: Integration tests for City Report Viewer
 */
public class CityReportViewerIntegrationTests {

    /**
     * The application to test
     */
    static App app;

    /**
     * Our first city we find in the db, we will use this
     */
    private static CityJoinCountry _city;

    /**
     * Set up the database connection by calling initialise method on App
     */
    @BeforeAll
    static void init()
    {
        // create arguments to run the app
        String[] args = new String[2];
        args[0] = "localhost:33060";
        args[1] = "300";

        // run the initialise method directly
        app = new App();
        App.initialise(app, args);

        //  Get the first capital city from the database and use that for passing parameters in for our tests
        _city = App.cityRepo.getAllCitiesJoinCountryOrderedByPopulation().get(0);

    }

    /**
     * Close the database connection after all the tests have run
     */
    @AfterAll
    static void dispose(){
        app.disconnect();
    }

    /**
     * First test is to make sure our reference city is not null or default
     */
    @Test
    void testReferenceData(){
        assertNotNull(_city);
        assertTrue(_city.id > 0);
    }


    /**
     * Integration test for ShowCityDetails
     */
    @Test
    void testsShowCityDetails(){
        App.cityReports.ShowCityDetails(1); // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowCitiesByPopulation
     */
    @Test
    void testsShowCitiesByPopulation(){
        App.cityReports.ShowCitiesByPopulation(); // No testable output - this test ensures that no exceptions are thrown
    }
    /**
     * Integration test for ShowCitiesInContinentByPopulation
     */
    @Test
    void testsShowCitiesInContinentByPopulation(){
        App.cityReports.ShowCitiesInContinentByPopulation(_city.Continent); // No testable output - this test ensures that no
        // exceptions are thrown
    }
    /**
     * Integration test for getAllCitiesByDistrictOrderedByPopulation
     */
    @Test
    void testsShowCitiesInCDistrictByPopulation(){
        App.cityReports.ShowCitiesInDistrictByPopulation(_city.district); // No testable output - this test ensures that no
        // exceptions are thrown
    }
    /**
     * Integration test for ShowCitiesInCountryByPopulation
     */
    @Test
    void testsShowCitiesInCountryByPopulation(){
        App.cityReports.ShowCitiesInCountryByPopulation(_city.countryCode); // No testable output - this test ensures that no
        // exceptions are thrown
    }
    /**
     * Integration test for ShowCitiesInRegionByPopulation
     */
    @Test
    void testsShowCitiesInRegionByPopulation(){
        App.cityReports.ShowCitiesInRegionByPopulation(_city.Region); // No testable output - this test ensures that no
        // exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesByPopulation
     */
    @Test
    void testsShowTopNCitiesByPopulation(){
        App.cityReports.ShowTopNCitiesByPopulation(1); // No testable output - this test ensures that no exceptions
        // are thrown
    }

    /**
     * Integration test for ShowCitiesInCountryByPopulation
     */
    @Test
    void testsShowTopNCitiesInCountryByPopulation(){
        App.cityReports.ShowTopNCitiesInCountryByPopulation(1, _city.countryName); // No testable output - this test
        // ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesInContinentByPopulation
     */
    @Test
    void testsShowTopNCitiesInContinentByPopulation(){
        App.cityReports.ShowTopNCitiesInContinentByPopulation(1, _city.Continent); // No testable output - this test ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesInDistrictByPopulation
     */
    @Test
    void testsShowTopNCitiesInDistrictByPopulation(){
        App.cityReports.ShowTopNCitiesInDistrictByPopulation(1, _city.district); // No testable output - this test ensures
        // that no exceptions are thrown
    }
}
