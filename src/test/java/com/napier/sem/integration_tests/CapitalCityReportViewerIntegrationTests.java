package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.CapitalCity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewems
 * Date Created: 13/03/2022 20:37
 * File Purpose: Integration tests for CapitalCityReportViewer
 */
public class CapitalCityReportViewerIntegrationTests {


    /**
     * The application to test
     */
    static App app;

    /**
     * Our first city we find in the db, we will use this
     */
    private static CapitalCity _capitalCity;

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
        _capitalCity = App.capitalCityRepo.getAllCapitalCitiesOrderedByPopulation().get(0);
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
        assertNotNull(_capitalCity);
        assertTrue(_capitalCity.name.length() > 0);
    }

    /**
     * Integration test for ShowCapitalCitiesInContinentByPopulation
     */
    @Test
    void testsShowCapitalCitiesInContinentByPopulation(){
        App.capitalCityReports.ShowCapitalCitiesInContinentByPopulation(_capitalCity.Continent); // No testable output - this
        // test
        // ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowCapitalCitiesByPopulation
     */
    @Test
    void testsShowCapitalCitiesByPopulation(){
        App.capitalCityReports.ShowCapitalCitiesByPopulation(); // No testable output - this
        // test
        // ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowCapitalCitiesInRegionByPopulation
     */
    @Test
    void testsShowCapitalCitiesInRegionByPopulation(){
        App.capitalCityReports.ShowCapitalCitiesInRegionByPopulation(_capitalCity.region); // No testable output - this
        // test
        // ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCapitalCitiesByPopulation
     */
    @Test
    void testsShowTopNCapitalCitiesByPopulation(){
        App.capitalCityReports.ShowTopNCapitalCitiesByPopulation(1); // No testable output - this test ensures
        // that no exceptions are thrown
    }
}
