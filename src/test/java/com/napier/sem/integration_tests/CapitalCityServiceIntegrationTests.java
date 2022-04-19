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
@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts") // Integration tests may use multiple assertions
class CapitalCityServiceIntegrationTests {

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
        assertNotNull(_capitalCity, "Check we have some data");
        assertTrue(_capitalCity.name.length() > 0, "We don't know what the value is but we can check it's not empty");

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
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.country.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
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
        assertTrue(city1.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city1.country.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city1.name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city1.population > city2.population && city2.population > city3.population, "Check that the " +
                "population of the first city is greater than the population of the second and so-on");
    }

    /**
     * Integration test for getAllCapitalCitiesByRegionOrderedByPopulation
     */
    @Test
    void testGetAllCapitalCitiesByRegionOrderedByPopulation(){
        //Arrange and Act
        var cities = App.capitalCityService
                .getAllCapitalCitiesInRegionOrderedByPopulation(_capitalCity.region);
        var city = cities.get(0);

        // Assert
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.country.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getTopNCapitalCitiesOrderedByPopulation
     */
    @Test
    void testGetTopNCapitalCitiesInWorldOrderedByPopulation(){
        // Arrange & Act
        var capitalCities = App.capitalCityService.getTopNCapitalCitiesInWorldOrderedByPopulation(1);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(capitalCities.isEmpty(), "Check we have some data");

        var capitalCity = capitalCities.get(0);

        // Assert
        assertTrue(capitalCities.size() <= 1, "Check we get at most, one item in the collection");
        assertTrue(capitalCity.name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(capitalCity.region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.country.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getTopNCapitalCitiesInRegionOrderedByPopulation
     */
    @Test
    void testGetTopNCapitalCitiesInRegionOrderedByPopulation(){
        // Arrange & Act
        var capitalCities = App.capitalCityService.getTopNCapitalCitiesInRegionOrderedByPopulation(1, _capitalCity.region);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(capitalCities.isEmpty(), "Check we have some data");

        var capitalCity = capitalCities.get(0);

        // Assert
        assertTrue(capitalCities.size() <= 1, "Check we get at most, one item in the collection");
        assertTrue(capitalCity.name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(capitalCity.region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.country.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getTopNCapitalCitiesInRegionOrderedByPopulation
     */
    @Test
    void testGetTopNCapitalCitiesInContinentOrderedByPopulation(){
        // Arrange & Act
        var capitalCities = App.capitalCityService.getTopNCapitalCitiesInContinentOrderedByPopulation(1, _capitalCity.Continent);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(capitalCities.isEmpty(), "Check we have some data");

        var capitalCity = capitalCities.get(0);

        // Assert
        assertTrue(capitalCities.size() <= 1, "Check we get at most, one item in the collection");
        assertTrue(capitalCity.name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(capitalCity.region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.country.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(capitalCity.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
    }


}
