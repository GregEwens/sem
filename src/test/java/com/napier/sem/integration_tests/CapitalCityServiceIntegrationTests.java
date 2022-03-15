package com.napier.sem.integration_tests;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Laura Main
 * Date Created: 13/03/2022 19:30
 * File Purpose: Integration Tests for capital city reports
 */
public class CapitalCityServiceIntegrationTests {

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
     * Integration test for getAllCapitalCitiesByContinentOrderedByPopulation
     */
    @Test
    void testGetAllCapitalCitiesByContinentOrderedByPopulation(){
        //Arrange and Act
        var cities = App.capitalCityService.getAllCapitalCitiesByContinentOrderedByPopulation("North America");
        var city = cities.get(0);

        // Assert
        assertTrue(city.population > 0);
        assertTrue(city.country.length() > 0);
        assertTrue(city.name.length() > 0);
    }
}
