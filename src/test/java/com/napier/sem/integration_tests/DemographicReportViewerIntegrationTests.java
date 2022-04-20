package com.napier.sem.integration_tests;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 11/04/2022 16:28
 * File Purpose: Integration tests for Demographic Report Viewer
 */
@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts") // Integration tests may use multiple assertions
class DemographicReportViewerIntegrationTests {
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
        assertDoesNotThrow(() -> App.demographicReports.showKeyDemographicReport()); // No testable output - this test
        // ensures that no exceptions are thrown
    }
}
