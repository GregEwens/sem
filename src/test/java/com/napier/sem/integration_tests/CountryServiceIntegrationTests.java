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
 * Date Created: 13/03/2022 19:08
 * File Purpose: Integration Tests for Country reports
 */
public class CountryServiceIntegrationTests {

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
        var countries = App.countryService
                .getAllCountriesOrderByPopulation();

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(countries.isEmpty());

        var country = countries.get(0);

        // Assert
        assertTrue(country.Code.length() > 0);
        assertTrue(country.Name.length() > 0);
        assertTrue(country.Continent.length() > 0);
        assertTrue(country.Region.length() > 0);
        assertTrue(country.Population > 0);
        assertTrue(country.Capital.length() > 0);
    }

    /**
     * Integration test for getAllCountriesOrderByPopulation
     */
    @Test
    void testGetTopNCountriesInRegionOrderedByPopulation()
    {
        // Arrange & Act
        var countries = App.countryService
                .getTopNCountriesInRegionOrderedByPopulation(10, "Southern Europe");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(countries.isEmpty());

        var country = countries.get(0);

        // Assert
        assertTrue(countries.size() <= 10);
        assertTrue(country.Code.length() > 0);
        assertTrue(country.Name.length() > 0);
        assertTrue(country.Continent.length() > 0);
        assertTrue(country.Region.length() > 0);
        assertTrue(country.Population > 0);
        assertTrue(country.Capital.length() > 0);
    }

    /**
     * Integration test for getTopNCountriesInContinentOrderedByPopulation
     */
    @Test
    void testGetTopNCountriesInContinentOrderedByPopulation()
    {
        // Arrange & Act
        var countries = App.countryService
                .getTopNCountriesInContinentOrderedByPopulation(10, "South America");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(countries.isEmpty());

        var country = countries.get(0);

        // Assert
        assertTrue(countries.size() <= 10);
        assertTrue(country.Code.length() > 0);
        assertTrue(country.Name.length() > 0);
        assertTrue(country.Continent.length() > 0);
        assertTrue(country.Region.length() > 0);
        assertTrue(country.Population > 0);
        assertTrue(country.Capital.length() > 0);
    }

    /**
     * Integration test for getTopNCountriesOrderedByPopulation
     */
    @Test
    void testGetTopNCountriesOrderedByPopulation()
    {
        // Arrange & Act
        var countries = App.countryService
                .getTopNCountriesOrderedByPopulation(10);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(countries.isEmpty());

        var country = countries.get(0);

        // Assert
        assertTrue(countries.size() <= 10);
        assertTrue(country.Code.length() > 0);
        assertTrue(country.Name.length() > 0);
        assertTrue(country.Continent.length() > 0);
        assertTrue(country.Region.length() > 0);
        assertTrue(country.Population > 0);
        assertTrue(country.Capital.length() > 0);
    }

    /**
     * Integration test for getTopNCountriesOrderedByPopulation
     */
    @Test
    void testGetAllCountriesInContinentOrderedByPopulation()
    {
        // Arrange & Act
        var countries = App.countryService
                .getAllCountriesInContinentOrderedByPopulation("Europe");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(countries.isEmpty());

        var country = countries.get(0);

        // Assert
        assertTrue(country.Code.length() > 0);
        assertTrue(country.Name.length() > 0);
        assertTrue(country.Continent.length() > 0);
        assertTrue(country.Region.length() > 0);
        assertTrue(country.Population > 0);
        assertTrue(country.Capital.length() > 0);
    }

    /**
     * Integration test for getAllCountriesInRegionOrderedByPopulation
     */
    @Test
    void testGetAllCountriesInRegionOrderedByPopulation()
    {
        // Arrange & Act
        var countries = App.countryService
                .getAllCountriesInRegionOrderedByPopulation("Polynesia");

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(countries.isEmpty());

        var country = countries.get(0);

        // Assert
        assertTrue(country.Code.length() > 0);
        assertTrue(country.Name.length() > 0);
        assertTrue(country.Continent.length() > 0);
        assertTrue(country.Region.length() > 0);
        assertTrue(country.Population > 0);
        assertTrue(country.Capital.length() > 0);
    }
}
