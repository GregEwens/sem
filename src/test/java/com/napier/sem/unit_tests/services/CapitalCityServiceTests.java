package com.napier.sem.unit_tests.services;

import com.napier.sem.repositories.ICapitalCityRepository;
import com.napier.sem.services.CapitalCityService;
import com.napier.sem.services.CityService;
import com.napier.sem.unit_tests.repositories.CapitalCityRepositoryMock;
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

        assertTrue(populationFirst > populationSecond && populationSecond > populationThird && populationThird > populationFourth);
    }

    /**
     *  getAllCapitalCitiesOrderedByPopulation tested for returning all items.
     *
     */
    @Test
    void getAllCapitalCitiesOrderedByPopulationReturnsAllCitiesTest(){
        //Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);

        //Act
        var capitalCities = systemUnderTest.getAllCapitalCitiesOrderedByPopulation();

        //Assert
        assertEquals(30,capitalCities.size());
    }

    /**
     * getTopNCitiesOrderedByPopulation tested for correct ordering
     */
    @Test
    void getAllCapitalCitiesOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);

        // Act
        var cities = systemUnderTest.getAllCapitalCitiesOrderedByPopulation();

        // Assert
        var populationFirst = cities.get(0).population;
        var populationSecond = cities.get(1).population;
        var populationThird = cities.get(2).population;
        var populationFourth = cities.get(3).population;

        assertTrue(populationFirst > populationSecond && populationSecond > populationThird && populationThird > populationFourth);
    }

    /**
     * getAllCapitalCitiesInRegionOrderedByPopulation tested to check correct count of Capital Cities returned
     */
    @Test
    void getAllCapitalCitiesInRegionOrderedByPopulationReturnsCorrectCountTest(){
        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var regionName = "Middle East";

        //Act
        var capitalCities = systemUnderTest.getAllCapitalCitiesInRegionOrderedByPopulation(regionName);

        //Assert
        assertEquals(15, capitalCities.size());
    }

    /**
     * getAllCapitalCitiesInRegionOrderedByPopulation tested to check correct region returned
     */
    @Test
    void getAllCapitalCitiesInRegionOrderedByPopulationReturnsCorrectRegionTest(){
        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var regionName = "Middle East";

        //Act
        var capitalCities = systemUnderTest.getAllCapitalCitiesInRegionOrderedByPopulation(regionName);
        var capitalCity = capitalCities.get(0);

        //Assert
        assertEquals("Middle East", capitalCity.region);
    }

    /**
     * getAllCapitalCitiesInRegionOrderedByPopulation tested to check correct order of Capital Cities returned
     */
    @Test
    void getAllCapitalCitiesInRegionOrderedByPopulationReturnsCorrectOrderingTest(){
        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var regionName = "Middle East";

        //Act
        var capitalCities = systemUnderTest.getAllCapitalCitiesInRegionOrderedByPopulation(regionName);


        //Assert
        var populationFirst = capitalCities.get(0).population;
        var populationSecond = capitalCities.get(1).population;
        var populationThird = capitalCities.get(2).population;
        var populationFourth = capitalCities.get(3).population;

        assertTrue(populationFirst > populationSecond && populationSecond > populationThird && populationThird > populationFourth);

    }

    /**
     * getAllCapitalCitiesInRegionOrderedByPopulation tested to check casing differences returns result
     */
    @Test
    void getAllCapitalCitiesInRegionOrderedByPopulationReturnsCorrectLowerCaseTest(){
        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var regionName = "middle east";

        //Act
        var capitalCities = systemUnderTest.getAllCapitalCitiesInRegionOrderedByPopulation(regionName);
        var capitalCity = capitalCities.get(0);

        //Assert
        assertEquals("Middle East", capitalCity.region);
    }

    /**
     * getAllCapitalCitiesInRegionOrderedByPopulation tested to check casing differences returns result
     */
    @Test
    void getAllCapitalCitiesInRegionOrderedByPopulationReturnsCorrectUpperCaseTest(){
        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var regionName = "MIDDLE EAST";

        //Act
        var capitalCities = systemUnderTest.getAllCapitalCitiesInRegionOrderedByPopulation(regionName);
        var capitalCity = capitalCities.get(0);

        //Assert
        assertEquals("Middle East", capitalCity.region);
    }

    /**
     * getAllCapitalCitiesInRegionOrderedByPopulation tested to check not found correctly
     */
    @Test
    void getAllCapitalCitiesInRegionOrderedByPopulationReturnsEmptyListTest(){
        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var regionName = "Not a Region";

        //Act
        var capitalCities = systemUnderTest.getAllCapitalCitiesInRegionOrderedByPopulation(regionName);

        //Assert
        assertTrue(capitalCities.size() == 0);
    }


}
