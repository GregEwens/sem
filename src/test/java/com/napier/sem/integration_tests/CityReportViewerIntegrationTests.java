package com.napier.sem.integration_tests;

import com.napier.sem.App;
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
        String[] args = new String[2];
        args[0] = "localhost:33060";
        args[1] = "300";

        app = new App();
        app.initialise(app, args);
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
        app.cityReports.ShowCityDetails(1); // No testable output - this test ensures that no exceptions are thrown
    }
}
