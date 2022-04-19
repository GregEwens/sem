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
@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts") // Integration tests may use multiple assertions
class CountryServiceIntegrationTests {

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
     * First test is to make sure our reference country is not null or default
     */
    @Test
    void testReferenceData(){
        assertNotNull(_country, "Check we have some data");
        assertTrue(_country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
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
        assertFalse(countries.isEmpty(), "Check we have some data");

        var country = countries.get(0);

        // Assert
        assertTrue(country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(country.Capital.length() > 0, "We don't know what the value is but we can check it's not empty");
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
        assertFalse(countries.isEmpty(), "Check we have some data");

        var country = countries.get(0);

        // Assert
        assertTrue(countries.size() <= 1, "Check we do not exceed the specified count");
        assertTrue(country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(country.Capital.length() > 0, "We don't know what the value is but we can check it's not empty");
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
        assertFalse(countries.isEmpty(), "Check we have some data");

        var country = countries.get(0);

        // Assert
        assertTrue(countries.size() <= 1, "Check we do not exceed the specified count");
        assertTrue(country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(country.Capital.length() > 0, "We don't know what the value is but we can check it's not empty");
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
        assertFalse(countries.isEmpty(), "Check we have some data");

        var country = countries.get(0);

        // Assert
        assertTrue(countries.size() <= 1, "Check we do not exceed the specified count");
        assertTrue(country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(country.Capital.length() > 0, "We don't know what the value is but we can check it's not empty");
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
        assertFalse(countries.isEmpty(), "Check we have some data");

        var country = countries.get(0);

        // Assert
        assertTrue(country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(country.Capital.length() > 0, "We don't know what the value is but we can check it's not empty");
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
        assertFalse(countries.isEmpty(), "Check we have some data");

        var country = countries.get(0);

        // Assert
        assertTrue(country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Name.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Continent.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Region.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(country.Population > 0, "We don't know what the value is but we can check it's not the default");
        assertTrue(country.Capital.length() > 0, "We don't know what the value is but we can check it's not empty");
    }
}
