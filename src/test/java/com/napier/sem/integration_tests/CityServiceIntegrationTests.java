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
     * Integration test for getCityById
     */
    @Test
    void testGetCity()
    {
        var city = App.cityService.getCityById(1);

        assertEquals(city.id, 1);
        assertEquals(city.population, 1780000);
        assertEquals(city.district, "Kabol");
        assertEquals(city.countryCode, "AFG");
        assertEquals(city.name, "Kabul");
    }

    /**
     * Integration test for getAllCitiesByContinentOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByContinentOrderedByPopulation(){
        var cities = App.cityService.getAllCitiesByContinentOrderedByPopulation("Europe");
        var city = cities.get(0);

        assertEquals(city.id, 3580);
        assertEquals(city.population, 8389200);
        assertEquals(city.district, "Moscow (City)");
        assertEquals(city.countryCode, "RUS");
        assertEquals(city.name, "Moscow");
    }

    /**
     * Integration test for getAllCitiesByRegionOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByRegionOrderedByPopulation(){
        var cities = App.cityService.getAllCitiesByRegionOrderedByPopulation("British Islands");
        var city = cities.get(0);

        assertEquals(city.id, 456);
        assertEquals(city.population, 7285000);
        assertEquals(city.district, "England");
        assertEquals(city.countryCode, "GBR");
        assertEquals(city.name, "London");
    }

    /**
     * Integration test for getAllCitiesByCountryOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByCountryOrderedByPopulation(){
        var cities = App.cityService.getAllCitiesByCountryOrderedByPopulation("GBR");

        var city = cities.get(0);

        assertEquals(city.id, 456);
        assertEquals(city.population, 7285000);
        assertEquals(city.district, "England");
        assertEquals(city.countryCode, "GBR");
        assertEquals(city.name, "London");
    }

    /**
     * Integration test for getAllCitiesByDistrictOrderedByPopulation
     */
    @Test
    void testGetAllCitiesByDistrictOrderedByPopulation(){
        var cities = App.cityService.getAllCitiesByDistrictOrderedByPopulation("Scotland");

        var city = cities.get(0);

        assertEquals(city.id, 458);
        assertEquals(city.population, 619680);
        assertEquals(city.district, "Scotland");
        assertEquals(city.countryCode, "GBR");
        assertEquals(city.name, "Glasgow");
    }

    /**
     * Integration test for getTopNCitiesOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesOrderedByPopulation(){
        var cities = App.cityService.getTopNCitiesOrderedByPopulation(10);

        var city = cities.get(0);

        assertEquals(10, cities.size());
        assertEquals(city.id, 1024);
        assertEquals(city.population, 10500000);
        assertEquals(city.district, "Maharashtra");
        assertEquals(city.countryCode, "IND");
        assertEquals(city.name, "Mumbai (Bombay)");
    }

    /**
     * Integration test for getTopNCitiesInRegionOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInRegionOrderedByPopulation(){
        var cities = App.cityService.getTopNCitiesInRegionOrderedByPopulation(10, "Caribbean");

        var city = cities.get(0);

        assertEquals(10, cities.size());
        assertEquals(city.id, 2413);
        assertEquals(city.population, 2256000);
        assertEquals(city.district, "La Habana");
        assertEquals(city.countryCode, "CUB");
        assertEquals(city.name, "La Habana");
    }

    /**
     * Integration test for getTopNCitiesInCountryOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInCountryOrderedByPopulation(){
        var cities = App.cityService.getTopNCitiesInCountryOrderedByPopulation(10, "Germany");

        var city = cities.get(0);

        assertEquals(10, cities.size());
        assertEquals(city.id, 3068);
        assertEquals(city.population, 3386667);
        assertEquals(city.district, "Berliini");
        assertEquals(city.countryCode, "DEU");
        assertEquals(city.name, "Berlin");
    }

    /**
     * Integration test for getTopNCitiesInContinentOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInContinentOrderedByPopulation(){
        var cities = App.cityService.getTopNCitiesInContinentOrderedByPopulation(10, "Africa");

        var city = cities.get(0);

        assertEquals(10, cities.size());
        assertEquals(city.id, 608);
        assertEquals(city.population, 6789479);
        assertEquals(city.district, "Kairo");
        assertEquals(city.countryCode, "EGY");
        assertEquals(city.name, "Cairo");
    }

    /**
     * Integration test for getTopNCitiesInDistrictOrderedByPopulation
     */
    @Test
    void testGetTopNCitiesInDistrictOrderedByPopulation(){
        var cities = App.cityService.getTopNCitiesInDistrictOrderedByPopulation(15, "Ontario");

        var city = cities.get(0);

        assertEquals(15, cities.size());
        assertEquals(city.id, 1812);
        assertEquals(city.population, 688275);
        assertEquals(city.district, "Ontario");
        assertEquals(city.countryCode, "CAN");
        assertEquals(city.name, "Toronto");
    }

    /**
     * Integration test for getAllCitiesOrderedByPopulation
     */
    @Test
    void testGetAllCitiesOrderedByPopulation(){
        var cities = App.cityService.getAllCitiesOrderedByPopulation();

        var city = cities.get(0);

        assertEquals(city.id, 1024);
        assertEquals(city.population, 10500000);
        assertEquals(city.district, "Maharashtra");
        assertEquals(city.countryCode, "IND");
        assertEquals(city.name, "Mumbai (Bombay)");
    }
}
