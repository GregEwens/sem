package com.napier.sem.integration_tests; /**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 13/03/2022 13:44
 * File Purpose: Integration Tests for application
 */

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTests {

    static App app;

    @BeforeAll
    static void init()
    {
        String[] args = new String[2];
        args[0] = "localhost:33060";
        args[1] = "30000";

        app = new App();
        app.initialise(app, args);
    }

    @AfterAll
    static void dispose(){
        app.disconnect();
    }

    @Test
    void testGetCity()
    {
        var city = app.cityService.getCityById(1);

        assertEquals(city.id, 1);
        assertEquals(city.population, 1780000);
        assertEquals(city.district, "Kabol");
        assertEquals(city.countryCode, "AFG");
        assertEquals(city.name, "Kabul");
    }

    @Test
    void testGetAllCitiesByContinentOrderedByPopulation(){
        var cities = app.cityService.getAllCitiesByContinentOrderedByPopulation("Europe");
        var city = cities.get(0);

        assertEquals(city.id, 3580);
        assertEquals(city.population, 8389200);
        assertEquals(city.district, "Moscow (City)");
        assertEquals(city.countryCode, "RUS");
        assertEquals(city.name, "Moscow");
    }

    @Test
    void testGetAllCitiesByRegionOrderedByPopulation(){
        var cities = app.cityService.getAllCitiesByRegionOrderedByPopulation("British Islands");
        var city = cities.get(0);

        assertEquals(city.id, 456);
        assertEquals(city.population, 7285000);
        assertEquals(city.district, "England");
        assertEquals(city.countryCode, "GBR");
        assertEquals(city.name, "London");
    }

    @Test
    void testGetAllCitiesByCountryOrderedByPopulation(){
        var cities = app.cityService.getAllCitiesByCountryOrderedByPopulation("GBR");

        var city = cities.get(0);

        assertEquals(city.id, 456);
        assertEquals(city.population, 7285000);
        assertEquals(city.district, "England");
        assertEquals(city.countryCode, "GBR");
        assertEquals(city.name, "London");
    }
}
