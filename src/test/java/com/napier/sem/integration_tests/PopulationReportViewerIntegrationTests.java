package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.Country;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: <<Your name here>>
 * Date Created: 09/04/2022 15:27
 * File Purpose: Integration tests for Population Report Viewer
 */
public class PopulationReportViewerIntegrationTests {

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
        assertNotNull(_country);
        assertTrue(_country.Code.length() > 0);
    }

    /**
     * Integration test for ShowPopulationReportForCountry
     */
    @Test
    void testsShowPopulationReportForCountry(){
        App.populationReports.ShowPopulationReportForCountry(_country.Name);
        // No testable output - this test ensures that no exceptions are thrown
    }

    /**
     * Integration test for ShowPopulationReportForCountry
     */
    @Test
    void testsShowPopulationReportForContinent(){
        App.populationReports.ShowPopulationReportForContinent(_country.Continent);
        // No testable output - this test ensures that no exceptions are thrown
    }


    /**
     * Integration test for ShowPopulationReportForCountry
     */
    @Test
    void testsShowPopulationReportForRegion(){
        App.populationReports.ShowPopulationReportForRegion(_country.Region);
        // No testable output - this test ensures that no exceptions are thrown
    }

}
