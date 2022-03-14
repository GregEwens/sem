package com.napier.sem.integration_tests;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    }

    /**
     * Close the database connection after all the tests have run
     */
    @AfterAll
    static void dispose(){
        app.disconnect();
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
        App.cityReports.ShowCitiesInContinentByPopulation("Europe"); // No testable output - this test ensures that no
        // exceptions are thrown
    }
    /**
     * Integration test for getAllCitiesByDistrictOrderedByPopulation
     */
    @Test
    void testsShowCitiesInCDistrictByPopulation(){
        App.cityReports.ShowCitiesInDistrictByPopulation("Tabasco"); // No testable output - this test ensures that no
        // exceptions are thrown
    }
    /**
     * Integration test for ShowCitiesInCountryByPopulation
     */
    @Test
    void testsShowCitiesInCountryByPopulation(){
        App.cityReports.ShowCitiesInCountryByPopulation("Germany"); // No testable output - this test ensures that no
        // exceptions are thrown
    }
    /**
     * Integration test for ShowCitiesInRegionByPopulation
     */
    @Test
    void testsShowCitiesInRegionByPopulation(){
        App.cityReports.ShowCitiesInRegionByPopulation("Western Africa"); // No testable output - this test ensures that no
        // exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesByPopulation
     */
    @Test
    void testsShowTopNCitiesByPopulation(){
        App.cityReports.ShowTopNCitiesByPopulation(10); // No testable output - this test ensures that no exceptions
        // are thrown
    }

    /**
     * Integration test for ShowCitiesInCountryByPopulation
     */
    @Test
    void testsShowTopNCitiesInCountryByPopulation(){
        App.cityReports.ShowTopNCitiesInCountryByPopulation(5, "Germany"); // No testable output - this test ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesInContinentByPopulation
     */
    @Test
    void testsShowTopNCitiesInContinentByPopulation(){
        App.cityReports.ShowTopNCitiesInContinentByPopulation(16, "Asia"); // No testable output - this test ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCitiesInDistrictByPopulation
     */
    @Test
    void testsShowTopNCitiesInDistrictByPopulation(){
        App.cityReports.ShowTopNCitiesInDistrictByPopulation(14, "Tabasco"); // No testable output - this test ensures
        // that no exceptions are thrown
    }
}
