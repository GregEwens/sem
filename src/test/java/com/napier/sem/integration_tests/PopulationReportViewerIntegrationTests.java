package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.CityJoinCountry;
import com.napier.sem.entities.Country;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: <<Your name here>>
 * Date Created: 09/04/2022 15:27
 * File Purpose: Integration tests for Population Report Viewer
 */
@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts") // Integration tests may use multiple assertions
class PopulationReportViewerIntegrationTests {

    /**
     * The application to test
     */
    static App app;

    /**
     * Our first city we find in the db, we will use this
     */
    private static Country _country;

    /**
     * Our first city we find in the db, we will use this as source data for our other tests
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
        _country = App.countryRepo.getAllCountriesOrderByPopulation().get(0);

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
     * First test is to make sure our reference country is not null or default
     */
    @Test
    void testReferenceData(){
        assertNotNull(_country, "Check we have some data");
        assertNotNull(_city, "Check we have some data");

        assertTrue(_country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(_city.id > -1, "We don't know what the value is but we can check it's not the default");
    }

    /**
     * Integration test for ShowPopulationReportForCountry
     */
    @Test
    void testsShowPopulationReportForCountry(){
        assertDoesNotThrow(() -> App.populationReports.ShowPopulationReportForCountry(_country.Name));
        // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowPopulationReportForContinent
     */
    @Test
    void testsShowPopulationReportForContinent(){
        assertDoesNotThrow(() -> App.populationReports.ShowPopulationReportForContinent(_country.Continent));
        // No testable output - this test ensures that no exceptions are thrown
    }


    /**
     * Integration test for ShowPopulationReportForRegion
     */
    @Test
    void testsShowPopulationReportForRegion(){
        assertDoesNotThrow(() -> App.populationReports.ShowPopulationReportForRegion(_country.Region));
        // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowBasicPopulationReportForWorld
     */
    @Test
    void testsShowBasicPopulationReportForWorld(){
        assertDoesNotThrow(() -> App.populationReports.ShowBasicPopulationReportForWorld());
        // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowBasicPopulationReportForContinent
     */
    @Test
    void testsShowBasicPopulationReportForContinent(){
        assertDoesNotThrow(() -> App.populationReports.ShowBasicPopulationReportForContinent(_country.Continent));
        // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowBasicPopulationReportForRegion
     */
    @Test
    void testsShowBasicPopulationReportForRegion(){
        assertDoesNotThrow(() -> App.populationReports.ShowBasicPopulationReportForRegion(_country.Region));
        // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowBasicPopulationReportForCountry
     */
    @Test
    void testsShowBasicPopulationReportForCountry(){
        assertDoesNotThrow(() -> App.populationReports.ShowBasicPopulationReportForCountry(_country.Name));
        // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowBasicPopulationReportForDistrict
     */
    @Test
    void testsShowBasicPopulationReportForDistrict(){
        assertDoesNotThrow(() -> App.populationReports.ShowBasicPopulationReportForDistrict(_city.district));
        // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowBasicPopulationReportForCity
     */
    @Test
    void testsShowBasicPopulationReportForCity(){
        assertDoesNotThrow(() -> App.populationReports.ShowBasicPopulationReportForCity(_city.name));
        // No testable output - this test ensures that no exceptions are thrown
    }
}
