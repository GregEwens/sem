package com.napier.sem.integration_tests;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 13/03/2022 20:41
 * File Purpose: Integration Tests for the App class
 */
public class AppIntegrationTests {

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
     * Tests the runReports method
     */
    @Test
    void testsRunReports(){
        App.runReports(app);
    }

    /**
     * Runs the full app
     */
    @Test
    void testFullApp(){
        String[] args = new String[2];
        args[0] = "localhost:33060";
        args[1] = "300";

        App.main(args);
    }
}
