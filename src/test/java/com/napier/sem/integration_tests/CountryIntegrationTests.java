package com.napier.sem.integration_tests;
/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Laura Main
 * Date Created: 13/03/2022 19:08
 * File Purpose: Integration Tests for Country reports
 */

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration Tests for Country reports
 */
public class CountryIntegrationTests {

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
        app.initialise(app, args);
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
        var countries = app.countryService.getAllCountriesOrderByPopulation();

        var country = countries.get(0);

        assertEquals(country.Code, "CHN");
        assertEquals(country.Name, "China");
        assertEquals(country.Continent, "Asia");
        assertEquals(country.Region, "Eastern Asia");
        assertEquals(country.Population, 1277558000);
        assertEquals(country.Capital, "Peking");
    }
}
