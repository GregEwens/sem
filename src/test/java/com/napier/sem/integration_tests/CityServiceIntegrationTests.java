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
 * Date Created: 13/03/2022 13:44
 * File Purpose: Integration Tests for city reports
 */
public class CityServiceIntegrationTests {

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
     * Integration test for getCityById
     */
    @Test
    void testGetCity()
    {
        // Arrange & Act
        var city = App.cityService.getCityById(1);

        // Assert
        assertEquals(city.id, 1);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);
    }

    /**
     * Integration test for getAllCitiesByContinentOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByContinentOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getAllCitiesByContinentOrderedByPopulation("Europe");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);
    }

    /**
     * Integration test for getAllCitiesByRegionOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByRegionOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getAllCitiesByRegionOrderedByPopulation("British Islands");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);
    }

    /**
     * Integration test for getAllCitiesByCountryOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByCountryOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getAllCitiesByCountryOrderedByPopulation("GBR");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);       }

    /**
     * Integration test for getAllCitiesByDistrictOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByDistrictOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getAllCitiesByDistrictOrderedByPopulation("Scotland");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);
    }

    /**
     * Integration test for getTopNCitiesOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService.getTopNCitiesOrderedByPopulation(10);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 10);
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);
    }

    /**
     * Integration test for getTopNCitiesInRegionOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInRegionOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getTopNCitiesInRegionOrderedByPopulation(10, "Caribbean");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 10);
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);
    }

    /**
     * Integration test for getTopNCitiesInCountryOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInCountryOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getTopNCitiesInCountryOrderedByPopulation(10, "Germany");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 10);
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);
    }

    /**
     * Integration test for getTopNCitiesInContinentOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInContinentOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getTopNCitiesInContinentOrderedByPopulation(10, "Africa");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 10);
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);

    }

    /**
     * Integration test for getTopNCitiesInDistrictOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInDistrictOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService
                .getTopNCitiesInDistrictOrderedByPopulation(15, "Ontario");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(cities.size() <= 15);
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);

    }

    /**
     * Integration test for getAllCitiesOrderedByPopulation
     */
    @Test
    void testGetAllCitiesOrderedByPopulation(){
        // Arrange & Act
        var cities = App.cityService.getAllCitiesOrderedByPopulation();

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(cities.isEmpty());

        var city = cities.get(0);

        // Assert
        assertTrue(city.id > 0);
        assertTrue(city.population > 0);
        assertTrue(city.district.length() > 0);
        assertTrue(city.countryCode.length() > 0);
        assertTrue(city.name.length() > 0);

    }
}
