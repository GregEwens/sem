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
 * Date Created: 09/04/2022 15:07
 * File Purpose: Integration tests for PopulationReportingService
 */
public class PopulationReportingServiceIntegrationTests {
    /**
     * The application to test
     */
    static App app;

    /**
     * Our first country we find in the db, we will use this as source data for our other tests
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

        //  Get the first country from the database and use that for passing parameters in for our tests
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
     * Integration test for getHighLevelPopulationDataForContinent
     */
    @Test
    void testGetHighLevelPopulationDataForContinent(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForContinent(_country.Continent);

        // Assert
        assertNotNull(populationCollection);
        assertTrue(populationCollection.Name.length() > 0);
    }

    /**
     * Integration test for getHighLevelPopulationDataForRegion
     */
    @Test
    void testGetHighLevelPopulationDataForRegion(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForRegion(_country.Region);

        // Assert
        assertNotNull(populationCollection);
        assertTrue(populationCollection.Name.length() > 0);
    }

    /**
     * Integration test for getHighLevelPopulationDataForRegion
     */
    @Test
    void testGetHighLevelPopulationDataForCountry(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForCountry(_country.Name);

        // Assert
        assertNotNull(populationCollection);
        assertTrue(populationCollection.Name.length() > 0);
    }
}
