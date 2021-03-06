package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.CityJoinCountry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 13/03/2022 20:07
 * File Purpose: Integration tests for City Report Viewer
 */
@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts") // Integration tests may use multiple assertions
class CityReportViewerIntegrationTests {

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
    static void init() {
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
        assertNotNull(_city, "Check we have some data");
        assertTrue(_city.id > 0, "We don't know what the value is but we can check it's not the default value");
    }

    /**
     * Integration test for ShowCityDetails
     */
    @Test
    void testsShowCityDetails(){
        assertDoesNotThrow(() -> App.cityReports.showCityDetails(1)); // No testable output - this test ensures that
        // no exceptions are thrown
    }

    /**
     * Integration test for ShowCitiesByPopulation
     */
    @Test
    void testsShowCitiesByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showCitiesByPopulation()); // No testable output - this test ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowCitiesInContinentByPopulation
     */
    @Test
    void testsShowCitiesInContinentByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showCitiesInContinentByPopulation(_city.continent)); // No testable
        // output - this test ensures that no
        // exceptions are thrown
    }

    /**
     * Integration test for getAllCitiesByDistrictOrderedByPopulation
     */
    @Test
    void testsShowCitiesInCDistrictByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showCitiesInDistrictByPopulation(_city.district)); // No testable output - this test ensures that no
        // exceptions are thrown
    }

    /**
     * Integration test for ShowCitiesInCountryByPopulation
     */
    @Test
    void testsShowCitiesInCountryByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showCitiesInCountryByPopulation(_city.countryCode)); // No testable output - this test ensures that no
        // exceptions are thrown
    }

    /**
     * Integration test for ShowCitiesInRegionByPopulation
     */
    @Test
    void testsShowCitiesInRegionByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showCitiesInRegionByPopulation(_city.region)); // No testable output - this test ensures that no
        // exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesByPopulation
     */
    @Test
    void testsShowTopNCitiesByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showTopNCitiesByPopulation(1)); // No testable output - this test ensures that no exceptions
        // are thrown
    }

    /**
     * Integration test for ShowCitiesInCountryByPopulation
     */
    @Test
    void testsShowTopNCitiesInCountryByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showTopNCitiesInCountryByPopulation(1, _city.countryName)); // No testable output - this test
        // ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesInContinentByPopulation
     */
    @Test
    void testsShowTopNCitiesInContinentByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showTopNCitiesInContinentByPopulation(1, _city.continent)); // No testable output - this test ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesInRegionByPopulation
     */
    @Test
    void testsShowTopNCitiesInRegionByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showTopNCitiesInRegionByPopulation(1, _city.region)); // No testable output - this test
        // ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesInDistrictByPopulation
     */
    @Test
    void testsShowTopNCitiesInDistrictByPopulation(){
        assertDoesNotThrow(() -> App.cityReports.showTopNCitiesInDistrictByPopulation(1, _city.district)); // No testable output - this test ensures
        // that no exceptions are thrown
    }
}
