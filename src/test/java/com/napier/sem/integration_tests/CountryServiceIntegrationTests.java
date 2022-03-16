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
     * Our first city we find in the db, we will use this
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

        //  Get the first capital city from the database and use that for passing parameters in for our tests
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
     * First test is to make sure our reference city is not null or default
     */
    @Test
    void testReferenceData(){
        assertNotNull(_country);
        assertTrue(_country.Code.length() > 0);
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
                .getTopNCountriesInRegionOrderedByPopulation(1, _country.Region);

        // Make this assertion here as if it is false we will throw an exception calling .get(0)
        assertFalse(countries.isEmpty());

        var country = countries.get(0);

        // Assert
        assertTrue(countries.size() <= 1);
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
                .getTopNCountriesInContinentOrderedByPopulation(1, _country.Continent);

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
                .getTopNCountriesOrderedByPopulation(1);

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
                .getAllCountriesInContinentOrderedByPopulation(_country.Continent);

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
                .getAllCountriesInRegionOrderedByPopulation(_country.Region);

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
