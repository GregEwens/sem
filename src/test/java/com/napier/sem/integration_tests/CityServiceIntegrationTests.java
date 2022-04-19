package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.CityJoinCountry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Laura Main
 * Date Created: 13/03/2022 13:44
 * File Purpose: Integration Tests for city reports
 */
@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts") // Integration tests may use multiple assertions
class CityServiceIntegrationTests {

    /**
     * The application to test
     */
    static App app;

    /**
     * Our first city we find in the db, we will use this as source data for our other tests
     */
    private static CityJoinCountry _city;

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
        _city = App.cityRepo.getAllCitiesJoinCountryOrderedByPopulation().get(0);
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
        assertNotNull(_city, "Check we have some data");
        assertTrue(_city.id > 0, "We don't know what the value is but we can check it's not the default value");
    }

    /**
     * Integration test for getCityById
     */
    @Test
    void testGetCity()
    {
        // Arrange & Act
        var city = App.cityService.getCityById(_city.id);

        // Assert
        assertEquals(city.id, _city.id, "Check the data matches what we supplied");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getAllCitiesByContinentOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByContinentOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getAllCitiesByContinentOrderedByPopulation(_city.Continent);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getAllCitiesByRegionOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByRegionOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getAllCitiesByRegionOrderedByPopulation(_city.Region);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getAllCitiesByCountryOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByCountryOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getAllCitiesByCountryOrderedByPopulation(_city.countryCode);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getAllCitiesByDistrictOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByDistrictOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getAllCitiesByDistrictOrderedByPopulation(_city.district);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getTopNCitiesOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService.getTopNCitiesOrderedByPopulation(1);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 1, "Check we do not exceed the specified count");
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getTopNCitiesInRegionOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInRegionOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getTopNCitiesInRegionOrderedByPopulation(1, _city.Region);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 1, "Check we do not exceed the specified count");
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getTopNCitiesInCountryOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInCountryOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getTopNCitiesInCountryOrderedByPopulation(1, _city.countryName);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 1, "Check we do not exceed the specified count");
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");
    }

    /**
     * Integration test for getTopNCitiesInContinentOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInContinentOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getTopNCitiesInContinentOrderedByPopulation(1, _city.Continent);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 1, "Check we do not exceed the specified count");
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");

    }

    /**
     * Integration test for getTopNCitiesInDistrictOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInDistrictOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getTopNCitiesInDistrictOrderedByPopulation(1, _city.district);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 1, "Check we do not exceed the specified count");
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");

    }

    /**
     * Integration test for getAllCitiesOrderedByPopulation
     */
    @Test
    void testGetAllCitiesOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService.getAllCitiesOrderedByPopulation();

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty(), "Check we have some data");

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(city.district.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.countryCode.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(city.name.length() > 0, "We don't know what the value is but we can check it's not empty");

    }
}
