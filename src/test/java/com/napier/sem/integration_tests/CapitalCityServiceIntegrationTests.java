package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.CapitalCity;
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
     * Integration test for getAllCapitalCitiesByContinentOrderedByPopulation
     */
    @Test
    void testGetAllCapitalCitiesByContinentOrderedByPopulation(){
        //Arrange and Act
        var cities = App.capitalCityService
                .getAllCapitalCitiesByContinentOrderedByPopulation(_capitalCity.Continent);
        var city = cities.get(0);

        // Assert
        assertTrue(city.population > 0);
        assertTrue(city.country.length() > 0);
        assertTrue(city.name.length() > 0);
    }

    /**
     * Integration test for getAllCapitalCitiesOrderedByPopulation
     */
    @Test
    void testGetAllCapitalCitiesOrderedByPopulation(){
        //Arrange and Act
        var cities = App.capitalCityService
                .getAllCapitalCitiesOrderedByPopulation();
        var city1 = cities.get(0);
        var city2 = cities.get(1);
        var city3 = cities.get(2);

        // Assert
        assertTrue(city1.population > 0);
        assertTrue(city1.country.length() > 0);
        assertTrue(city1.name.length() > 0);
        assertTrue(city1.population > city2.population && city2.population > city3.population);
    }
}
