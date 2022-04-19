package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.Country;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 13/03/2022 20:31
 * File Purpose: Integration tests for Country Report Viewer
 */
@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts") // Integration tests may use multiple assertions
class CountryReportViewerIntegrationTests {

    /**
     * The application to test
     */
    static App app;

    /**
     * Our first city we find in the db, we will use this
     */
    private static Country _country;

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
        assertTrue(_country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for ShowCountriesByPopulation
     */
    @Test
    void testsShowCountriesByPopulation(){
        assertDoesNotThrow(() -> App.countryReports.ShowCountriesByPopulation()); // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowCountriesInAContinentByPopulation
     */
    @Test
    void testsShowCountriesInAContinentByPopulation(){
        assertDoesNotThrow(() -> App.countryReports.ShowCountriesInAContinentByPopulation(_country.Continent)); // No testable output - this test ensures
        // that no exceptions are thrown
    }

    /**
     * Integration test for ShowCountriesInARegionByPopulation
     */
    @Test
    void testsShowCountriesInARegionByPopulation(){
        assertDoesNotThrow(() -> App.countryReports.ShowCountriesInARegionByPopulation(_country.Region)); // No testable output - this test ensures that
        // no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCountriesByPopulation
     */
    @Test
    void testsShowTopNCountriesByPopulation(){
        assertDoesNotThrow(() -> App.countryReports.ShowTopNCountriesByPopulation(1)); // No testable output - this test ensures that no
        // exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCountriesInContinentByPopulation
     */
    @Test
    void testsShowTopNCountriesInContinentByPopulation(){
        assertDoesNotThrow(() -> App.countryReports.ShowTopNCountriesInContinentByPopulation(1, _country.Continent)); // No testable output - this
        // test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowTopNCountriesInRegionByPopulation
     */
    @Test
    void testsShowTopNCountriesInRegionByPopulation(){
        assertDoesNotThrow(() -> App.countryReports.ShowTopNCountriesInRegionByPopulation(1, _country.Region)); // No testable output - this
        // test ensures that no exceptions are thrown
    }

}
