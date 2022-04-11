package com.napier.sem.integration_tests;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 11/04/2022 16:23
 * File Purpose: Integration tests for Language reports
 */
public class LanguageServiceIntegrationTests {

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
     * Integration test for getAllCountriesOrderByPopulation
     */
    @Test
    void testGetAllCountriesOrderByPopulation()
    {
        // Arrange & Act
        var languageModels = App.languageService.getDemographicReportModel();

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(languageModels.isEmpty());
        var languageModel = languageModels.get(0);

        // Assert
        assertTrue(languageModel.LanguageName.length() > 0);
        assertTrue(languageModel.Speakers > -1);
    }
}
