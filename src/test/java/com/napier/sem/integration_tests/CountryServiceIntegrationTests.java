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
        String[] args = new String[2];
        args[0] = "localhost:33060";
        args[1] = "300";

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
        var countries = App.countryService.getAllCountriesOrderByPopulation();

        var country = countries.get(0);

        assertEquals(country.Code, "CHN");
        assertEquals(country.Name, "China");
        assertEquals(country.Continent, "Asia");
        assertEquals(country.Region, "Eastern Asia");
        assertEquals(country.Population, 1277558000);
        assertEquals(country.Capital, "Peking");
    }

    /**
     * Integration test for getAllCountriesOrderByPopulation
     */
    @Test
    void testGetTopNCountriesInRegionOrderedByPopulation()
    {
        var countries = App.countryService.getTopNCountriesInRegionOrderedByPopulation(10, "Southern Europe");

        var country = countries.get(0);

        assertEquals(10, countries.size());
        assertEquals(country.Code, "ITA");
        assertEquals(country.Name, "Italy");
        assertEquals(country.Continent, "Europe");
        assertEquals(country.Region, "Southern Europe");
        assertEquals(country.Population, 57680000);
        assertEquals(country.Capital, "Roma");
    }

    /**
     * Integration test for getTopNCountriesInContinentOrderedByPopulation
     */
    @Test
    void testGetTopNCountriesInContinentOrderedByPopulation()
    {
        var countries = App.countryService.getTopNCountriesInContinentOrderedByPopulation(10, "South America");

        var country = countries.get(0);

        assertEquals(10, countries.size());
        assertEquals(country.Code, "BRA");
        assertEquals(country.Name, "Brazil");
        assertEquals(country.Continent, "South America");
        assertEquals(country.Region, "South America");
        assertEquals(country.Population, 170115000);
        assertEquals(country.Capital, "Brasília");
    }

    /**
     * Integration test for getTopNCountriesOrderedByPopulation
     */
    @Test
    void testGetTopNCountriesOrderedByPopulation()
    {
        var countries = App.countryService.getTopNCountriesOrderedByPopulation(10);

        var country = countries.get(0);

        assertEquals(10, countries.size());
        assertEquals(country.Code, "CHN");
        assertEquals(country.Name, "China");
        assertEquals(country.Continent, "Asia");
        assertEquals(country.Region, "Eastern Asia");
        assertEquals(country.Population, 1277558000);
        assertEquals(country.Capital, "Peking");
    }

    /**
     * Integration test for getTopNCountriesOrderedByPopulation
     */
    @Test
    void testGetAllCountriesInContinentOrderedByPopulation()
    {
        var countries = App.countryService.getAllCountriesInContinentOrderedByPopulation("Antarctica");

        var country = countries.get(0);

        assertEquals(5, countries.size());
        assertEquals(country.Code, "ATA");
        assertEquals(country.Name, "Antarctica");
        assertEquals(country.Continent, "Antarctica");
        assertEquals(country.Region, "Antarctica");
        assertEquals(country.Population, 0);
        assertNull(country.Capital);
    }

    /**
     * Integration test for getAllCountriesInRegionOrderedByPopulation
     */
    @Test
    void testGetAllCountriesInRegionOrderedByPopulation()
    {
        var countries = App.countryService.getAllCountriesInRegionOrderedByPopulation("Polynesia");

        var country = countries.get(0);

        assertEquals(10, countries.size());
        assertEquals(country.Code, "PYF");
        assertEquals(country.Name, "French Polynesia");
        assertEquals(country.Continent, "Oceania");
        assertEquals(country.Region, "Polynesia");
        assertEquals(country.Population, 235000);
        assertEquals(country.Capital, "Papeete");
    }
}
