package com.napier.sem.integration_tests;

import com.napier.sem.App;
import com.napier.sem.entities.CityJoinCountry;
import com.napier.sem.entities.Country;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Project Name: seMethods
 * Package: com.napier.sem.integration_tests
 * User: Greg Ewens
 * Date Created: 09/04/2022 15:07
 * File Purpose: Integration tests for PopulationReportingService
 */
@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts") // Integration tests may use multiple assertions
class PopulationReportingServiceIntegrationTests {
    /**
     * The application to test
     */
    static App app;

    /**
     * Our first country we find in the db, we will use this as source data for our other tests
     */
    private static Country _country;

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

        //  Get the first country from the database and use that for passing parameters in for our tests
        _country = App.countryRepo.getAllCountriesOrderByPopulation().get(0);

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
     * First test is to make sure our reference country is not null or default
     */
    @Test
    void testReferenceData(){
        assertNotNull(_country, "Check we have some data");
        assertNotNull(_city, "Check we have some data");

        assertTrue(_country.Code.length() > 0, "We don't know what the value is but we can check it's not empty");
        assertTrue(_city.id > -1, "We don't know what the value is but we can check it's not the default");
    }

    /**
     * Integration test for getHighLevelPopulationDataForContinent
     */
    @Test
    void testGetHighLevelPopulationDataForContinent(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForContinent(_country.Continent);

        // Assert
        assertNotNull(populationCollection, "Check we have some data");
        assertTrue(populationCollection.Name.length() > 0, "We don't know what the value is but we can check it's not the default");
    }

    /**
     * Integration test for getHighLevelPopulationDataForContinent handles a not found condition
     */
    @Test
    void testGetHighLevelPopulationDataForContinentHandlesNotFound(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForContinent("Not a continent");

        // Assert
        assertNull(populationCollection, "Check we have a proper null response");
    }


    /**
     * Integration test for getHighLevelPopulationDataForRegion
     */
    @Test
    void testGetHighLevelPopulationDataForRegion(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForRegion(_country.Region);

        // Assert
        assertNotNull(populationCollection, "Check we have some data");
        assertTrue(populationCollection.Name.length() > 0, "We don't know what the value is but we can check it's not the default");
    }

    /**
     * Integration test for getHighLevelPopulationDataForRegion handles a not found condition
     */
    @Test
    void testGetHighLevelPopulationDataForRegionHandlesNotFound(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForRegion("Not a region");

        // Assert
        assertNull(populationCollection, "Check we have a proper null response");
    }

    /**
     * Integration test for getHighLevelPopulationDataForRegion
     */
    @Test
    void testGetHighLevelPopulationDataForCountry(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForCountry(_country.Name);

        // Assert
        assertNotNull(populationCollection, "Check we have some data");
        assertTrue(populationCollection.Name.length() > 0, "We don't know what the value is but we can check it's not the default");
    }

    /**
     * Integration test for getHighLevelPopulationDataForCountry handles a not found condition
     */
    @Test
    void testGetHighLevelPopulationDataForCountryHandlesNotFound(){
        var populationCollection = App.populationReportingService
                .getHighLevelPopulationDataForCountry("Not a country");

        // Assert
        assertNull(populationCollection, "Check we have a proper null response");
    }

    /**
     * Integration test for GetPopulationOfWorld
     */
    @Test
    void testGetPopulationOfWorld(){
        var population = App.populationReportingService.getPopulationOfWorld();

        // Assert
        assertTrue(population > 0, "We don't know what the value is but we can check it's not zero");
    }

    /**
     * Integration test for GetPopulationOfRegion
     */
    @Test
    void testGetPopulationOfRegion(){
        var population = App.populationReportingService.getPopulationOfRegion(_country.Region);

        // Assert
        assertTrue(population > 0, "We don't know what the value is but we can check it's not zero");
    }

    /**
     * Integration test for GetPopulationOfRegion handles a not found condition
     */
    @Test
    void testGetPopulationOfRegionHandlesNotFound(){
        var population = App.populationReportingService.getPopulationOfRegion("Not a region");

        // Assert
        assertEquals(0, population, "Check the method returns the expected zero");
    }

    /**
     * Integration test for GetPopulationOfCountry
     */
    @Test
    void testGetPopulationOfCountry(){
        var population = App.populationReportingService.getPopulationOfCountry(_country.Name);

        // Assert
        assertTrue(population > 0, "We don't know what the value is but we can check it's not zero");
    }

    /**
     * Integration test for GetPopulationOfCountry handles a not found condition
     */
    @Test
    void testGetPopulationOfCountryHandlesNotFound(){
        var population = App.populationReportingService.getPopulationOfCountry("Not a country");

        // Assert
        assertEquals(0, population, "Check the method returns the expected zero");
    }

    /**
     * Integration test for GetPopulationOfContinent
     */
    @Test
    void testGetPopulationOfContinent(){
        var population = App.populationReportingService.getPopulationOfContinent(_country.Continent);

        // Assert
        assertTrue(population > 0, "We don't know what the value is but we can check it's not zero");
    }

    /**
     * Integration test for GetPopulationOfContinent handles a not found condition
     */
    @Test
    void testGetPopulationOfContinentHandlesNotFound(){
        var population = App.populationReportingService.getPopulationOfContinent("Not a continent");

        // Assert
        assertEquals(0, population, "Check the method returns the expected zero");
    }

    /**
     * Integration test for GetPopulationOfDistrict
     */
    @Test
    void testGetPopulationOfDistrict(){
        var population = App.populationReportingService.getPopulationOfDistrict(_city.district);

        // Assert
        assertTrue(population > 0, "We don't know what the value is but we can check it's not zero");
    }

    /**
     * Integration test for GetPopulationOfDistrict handles a not found condition
     */
    @Test
    void testGetPopulationOfDistrictHandlesNotFound(){
        var population = App.populationReportingService.getPopulationOfDistrict("Not a district");

        // Assert
        assertEquals(0, population, "Check the method returns the expected zero");
    }

    /**
     * Integration test for GetPopulationOfCity
     */
    @Test
    void testGetPopulationOfCity(){
        var population = App.populationReportingService.getPopulationOfCity(_city.name);

        // Assert
        assertTrue(population > 0, "We don't know what the value is but we can check it's not zero");
    }

    /**
     * Integration test for GetPopulationOfDistrict handles a not found condition
     */
    @Test
    void testGetPopulationOfCityHandlesNotFound(){
        var population = App.populationReportingService.getPopulationOfCity("Not a City");

        // Assert
        assertEquals(0, population, "Check the method returns the expected zero");
    }
}
