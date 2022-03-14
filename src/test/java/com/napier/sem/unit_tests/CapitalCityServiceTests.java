package com.napier.sem.unit_tests;

import com.napier.sem.repositories.ICapitalCityRepository;
import com.napier.sem.services.CapitalCityService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Laura Main
 * Date Created: 13/03/2022 19:46
 * File Purpose: Unit Tests for Capital City Service
 */
public class CapitalCityServiceTests {

    /**
     * Mockup of countryRepository
     */
    private static ICapitalCityRepository capitalCityRepositoryMock;

    /**
     * Constructs the Country Repository
     */
    @BeforeAll
    static void init()
    {
        capitalCityRepositoryMock = new CapitalCityRepositoryMock();
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with correct count
     */
    @Test
    void getAllCapitalCitiesByContinentOrderedByPopulationMatchesContinentTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var continent = "Oceania";

        // Act
        var cities = systemUnderTest.getAllCapitalCitiesByContinentOrderedByPopulation(continent);

        // Assert
        assertEquals(cities.size(), 15);
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with correct count
     */
    @Test
    void getAllCapitalCitiesByContinentOrderedByPopulationCorrectCountAllUpperTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var continent = "OCEANIA";

        // Act
        var cities = systemUnderTest.getAllCapitalCitiesByContinentOrderedByPopulation(continent);

        // Assert
        assertEquals(cities.size(), 15);
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with correct count
     */
    @Test
    void getAllCapitalCitiesByContinentOrderedByPopulationCountAllLowerTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var continent = "oceania";

        // Act
        var cities = systemUnderTest.getAllCapitalCitiesByContinentOrderedByPopulation(continent);

        // Assert
        assertEquals(cities.size(), 15);
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with 0 count
     */
    @Test
    void getAllCapitalCitiesByContinentOrderedByPopulationNotFoundTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var continent = "NotAContinent";

        // Act
        var cities = systemUnderTest.getAllCapitalCitiesByContinentOrderedByPopulation(continent);

        // Assert
        assertEquals(0, cities.size());
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested for correct ordering
     */
    @Test
    void getAllCapitalCitiesByContinentOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var continent = "Oceania";

        // Act
        var cities = systemUnderTest.getAllCapitalCitiesByContinentOrderedByPopulation(continent);

        // Assert
        var populationFirst = cities.get(0).population;
        var populationSecond = cities.get(1).population;
        var populationThird = cities.get(2).population;
        var populationFourth = cities.get(3).population;

        assertTrue(populationFirst < populationSecond && populationSecond < populationThird && populationThird < populationFourth);
    }

}
