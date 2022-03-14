package com.napier.sem.integration_tests;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 13/03/2022 20:31
 * File Purpose: Integration tests for Country Report Viewer
 */
public class CountryReportViewerIntegrationTests {

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
     * Integration test for ShowCountriesByPopulation
     */
    @Test
    void testsShowCountriesByPopulation(){
        App.countryReports.ShowCountriesByPopulation(); // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowCountriesInAContinentByPopulation
     */
    @Test
    void testsShowCountriesInAContinentByPopulation(){
        App.countryReports.ShowCountriesInAContinentByPopulation("Africa"); // No testable output - this test ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowCountriesInARegionByPopulation
     */
    @Test
    void testsShowCountriesInARegionByPopulation(){
        App.countryReports.ShowCountriesInARegionByPopulation("Central America"); // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCountriesByPopulation
     */
    @Test
    void testsShowTopNCountriesByPopulation(){
        App.countryReports.ShowTopNCountriesByPopulation(68); // No testable output - this test ensures that no
        // exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCountriesInContinentByPopulation
     */
    @Test
    void testsShowTopNCountriesInContinentByPopulation(){
        App.countryReports.ShowTopNCountriesInContinentByPopulation(3, "North America"); // No testable output - this
        // test ensures that no exceptions are thrown
    }
}
