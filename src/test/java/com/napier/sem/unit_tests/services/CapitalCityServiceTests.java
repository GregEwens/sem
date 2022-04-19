package com.napier.sem.unit_tests.services;

import com.napier.sem.repositories.ICapitalCityRepository;
import com.napier.sem.services.CapitalCityService;
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
class CapitalCityServiceTests {

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
        assertEquals(cities.size(), 15, "Mockup supplies this count");
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
        assertEquals(cities.size(), 15, "Mockup supplies this count");
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
        assertEquals(cities.size(), 15, "Mockup supplies this count");
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
        assertEquals(0, cities.size(), "Mockup supplies this count");
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

        assertTrue(populationFirst > populationSecond
                && populationSecond > populationThird
                && populationThird > populationFourth, "Ensures the ordering of the items matches requirements");
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
        assertEquals(30,capitalCities.size(), "Mockup supplies this count");
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

        assertTrue(populationFirst > populationSecond
                && populationSecond > populationThird
                && populationThird > populationFourth, "Ensures the ordering of the items matches requirements");
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
        assertEquals(15, capitalCities.size(), "Mockup supplies this count");
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
        assertEquals("Middle East", capitalCity.region, "Checks value specified matches that which is returned");
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

        assertTrue(populationFirst > populationSecond
                && populationSecond > populationThird
                && populationThird > populationFourth, "Ensures the ordering of the items matches requirements");

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
        assertEquals("Middle East", capitalCity.region, "Checks value specified matches that which is returned");
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
        assertEquals("Middle East", capitalCity.region, "Checks value specified matches that which is returned");
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
        assertEquals(0, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCapitalCitiesOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInWorldOrderedByPopulation(count);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 0;

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInWorldOrderedByPopulation(count);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCapitalCitiesOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = -1;

        // Assert
        assertThrows(IllegalArgumentException.class, () -> systemUnderTest.getTopNCapitalCitiesInWorldOrderedByPopulation(count));
    }

    /**
     * getTopNCapitalCitiesOrderedByPopulation tested with a count greater than the number of existing Capital Cities
     */
    @Test
    void getTopNCapitalCitiesOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 500;

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInWorldOrderedByPopulation(count);

        // Assert
        assertNotEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCapitalCitiesOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 4;

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInWorldOrderedByPopulation(count);

        // Assert
        var populationFirst = capitalCities.get(0).population;
        var populationSecond = capitalCities.get(1).population;
        var populationThird = capitalCities.get(2).population;
        var populationFourth = capitalCities.get(3).population;

        assertTrue(populationFirst > populationSecond
                && populationSecond > populationThird
                && populationThird > populationFourth, "Ensures the ordering of the items matches requirements");
    }



    /**
     * getTopNCapitalCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCapitalCitiesInRegionOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;
        var region = "Middle East";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCapitalCitiesInRegionOrderedByPopulationCorrectCountTestAllUpper(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;
        var region = "MIDDLE EAST";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCapitalCitiesInRegionOrderedByPopulationCorrectCountTestAllLower(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;
        var region = "middle east";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInRegionOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCaptialCitiesInRegionOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 0;
        var region = "Middle East";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInRegionOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCapitalCitiesInRegionOrderedByPopulationRegionNotFoundTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;
        var region = "NotARegion";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(0, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCapitalCitiesInRegionOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = -1;
        var region = "Middle East";

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> systemUnderTest.getTopNCapitalCitiesInRegionOrderedByPopulation(count, region));
    }

    /**
     * getTopNCapitalCitiesInRegionOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCapitalCitiesInRegionOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 20;
        var region = "Middle East";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertNotEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInRegionOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCapitalCitiesInRegionOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 4;
        var region = "Middle East";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        var populationFirst = capitalCities.get(0).population;
        var populationSecond = capitalCities.get(1).population;
        var populationThird = capitalCities.get(2).population;
        var populationFourth = capitalCities.get(3).population;

        assertTrue(populationFirst > populationSecond
                && populationSecond > populationThird
                && populationThird > populationFourth, "Ensures the ordering of the items matches requirements");
    }



    /**
     * getTopNCapitalCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCapitalCitiesInContinentOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;
        var continent = "Oceania";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInContinentOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCapitalCitiesInContinentOrderedByPopulationCorrectCountTestAllUpper(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;
        var continent = "OCEANIA";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInContinentOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCapitalCitiesInContinentOrderedByPopulationCorrectCountTestAllLower(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;
        var continent = "oceania";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInContinentOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCaptialCitiesInContinentOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 0;
        var continent= "Oceania";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInContinentOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCapitalCitiesInContinentOrderedByPopulationRegionNotFoundTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 10;
        var continent = "NotAContinent";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(0, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCapitalCitiesInContinentOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = -1;
        var continent = "Oceania";

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> systemUnderTest.getTopNCapitalCitiesInContinentOrderedByPopulation(count, continent));
    }

    /**
     * getTopNCapitalCitiesInContinentOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCapitalCitiesInContinentOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 20;
        var continent = "Oceania";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertNotEquals(count, capitalCities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCapitalCitiesInContinentOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCapitalCitiesInContinentOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CapitalCityService(capitalCityRepositoryMock);
        var count = 4;
        var continent = "Oceania";

        // Act
        var capitalCities = systemUnderTest.getTopNCapitalCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        var populationFirst = capitalCities.get(0).population;
        var populationSecond = capitalCities.get(1).population;
        var populationThird = capitalCities.get(2).population;
        var populationFourth = capitalCities.get(3).population;

        assertTrue(populationFirst > populationSecond
                && populationSecond > populationThird
                && populationThird > populationFourth, "Ensures the ordering of the items matches requirements");
    }



}
