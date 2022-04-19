package com.napier.sem.unit_tests.services;

import com.napier.sem.repositories.ICityRepository;
import com.napier.sem.services.CityService;
import com.napier.sem.unit_tests.repositories.CityRepositoryMock;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 12/03/2022 14:53
 * File Purpose: Unit Tests for CityService
 */
class CityServiceTests {

    /**
     * Mockup of countryRepository
     */
    private static ICityRepository cityRepositoryMock;

    /**
     * Constructs the Country Repository
     */
    @BeforeAll
    static void init()
    {
        cityRepositoryMock = new CityRepositoryMock();
    }

    /**
     * getTopNCountriesOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;

        // Act
        var cities = systemUnderTest.getTopNCitiesOrderedByPopulation(count);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCountriesOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 0;

        // Act
        var cities = systemUnderTest.getTopNCitiesOrderedByPopulation(count);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCountriesOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCitiesOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = -1;

        // Assert
        assertThrows(IllegalArgumentException.class, () -> systemUnderTest.getTopNCitiesOrderedByPopulation(count));
    }

    /**
     * getTopNCountriesOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCitiesOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 500;

        // Act
        var cities = systemUnderTest.getTopNCitiesOrderedByPopulation(count);

        // Assert
        assertNotEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCountriesOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCitiesOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 4;

        // Act
        var cities = systemUnderTest.getTopNCitiesOrderedByPopulation(count);

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
     * getTopNCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var region = "North Africa";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationCorrectCountTestAllUpperTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var region = "NORTH AFRICA";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationCorrectCountTestAllLowerTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var region = "north africa";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 0;
        var region = "North Africa";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationRegionNotFoundTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var region = "NotARegion";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(0, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = -1;
        var region = "North Africa";

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region));
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 20;
        var region = "North Africa";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertNotEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 4;
        var region = "North Africa";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

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
     * getTopNCitiesInCountryOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInCountryOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var country = "Egypt";

        // Act
        var cities = systemUnderTest.getTopNCitiesInCountryOrderedByPopulation(count, country);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInCountryOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInCountryOrderedByPopulationCorrectCountAllUpperTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var country = "EGYPT";

        // Act
        var cities = systemUnderTest.getTopNCitiesInCountryOrderedByPopulation(count, country);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInCountryOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInCountryOrderedByPopulationCorrectCountAllLowerTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var country = "egypt";

        // Act
        var cities = systemUnderTest.getTopNCitiesInCountryOrderedByPopulation(count, country);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInCountryOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesInCountryOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 0;
        var country = "Egypt";

        // Act
        var cities = systemUnderTest.getTopNCitiesInCountryOrderedByPopulation(count, country);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInCountryOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesInCountryOrderedByPopulationCountryNotFoundTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var country = "NotADistrict";

        // Act
        var cities = systemUnderTest.getTopNCitiesInCountryOrderedByPopulation(count, country);

        // Assert
        assertEquals(0, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInCountryOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCitiesInCountryOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = -1;
        var country = "Egypt";

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> systemUnderTest.getTopNCitiesInCountryOrderedByPopulation(count, country));
    }

    /**
     * getTopNCitiesInCountryOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCitiesInCountryOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 20;
        var country = "Egypt";

        // Act
        var cities = systemUnderTest.getTopNCitiesInCountryOrderedByPopulation(count, country);

        // Assert
        assertNotEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInCountryOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCitiesInCountryOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 4;
        var country = "Egypt";

        // Act
        var cities = systemUnderTest.getTopNCitiesInCountryOrderedByPopulation(count, country);

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
     * getTopNCitiesInDistrictOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInDistrictOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var district = "Queensland";

        // Act
        var cities = systemUnderTest.getTopNCitiesInDistrictOrderedByPopulation(count, district);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInDistrictOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInDistrictOrderedByPopulationCorrectCountAllUpperTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var district = "QUEENSLAND";

        // Act
        var cities = systemUnderTest.getTopNCitiesInDistrictOrderedByPopulation(count, district);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInDistrictOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInDistrictOrderedByPopulationCorrectCountAllLowerTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var district = "queensland";

        // Act
        var cities = systemUnderTest.getTopNCitiesInDistrictOrderedByPopulation(count, district);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInDistrictOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesInDistrictOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 0;
        var district = "Queensland";

        // Act
        var cities = systemUnderTest.getTopNCitiesInDistrictOrderedByPopulation(count, district);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInDistrictOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesInDistrictOrderedByPopulationDistrictNotFoundTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var district = "NotADistrict";

        // Act
        var cities = systemUnderTest.getTopNCitiesInDistrictOrderedByPopulation(count, district);

        // Assert
        assertEquals(0, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInDistrictOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCitiesInDistrictOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = -1;
        var district = "Queensland";

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> systemUnderTest.getTopNCitiesInDistrictOrderedByPopulation(count, district));
    }

    /**
     * getTopNCitiesInDistrictOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCitiesInDistrictOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 20;
        var district = "Queensland";

        // Act
        var cities = systemUnderTest.getTopNCitiesInDistrictOrderedByPopulation(count, district);

        // Assert
        assertNotEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInDistrictOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCitiesInDistrictOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 4;
        var district = "Queensland";

        // Act
        var cities = systemUnderTest.getTopNCitiesInDistrictOrderedByPopulation(count, district);

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
     * getTopNCitiesInContinentOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInContinentOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var continent = "Asia";

        // Act
        var cities = systemUnderTest.getTopNCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInContinentOrderedByPopulationCorrectCountAllUpperTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var continent = "ASIA";

        // Act
        var cities = systemUnderTest.getTopNCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInContinentOrderedByPopulationCountAllLowerTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var continent = "asia";

        // Act
        var cities = systemUnderTest.getTopNCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesInContinentOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 0;
        var continent = "Asia";

        // Act
        var cities = systemUnderTest.getTopNCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCitiesInContinentOrderedByPopulationNotFoundTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var continent = "NotAContinent";

        // Act
        var cities = systemUnderTest.getTopNCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertEquals(0, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCitiesInContinentOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = -1;
        var continent = "Asia";

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> systemUnderTest.getTopNCitiesInContinentOrderedByPopulation(count, continent));
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCitiesInContinentOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 20;
        var continent = "Asia";

        // Act
        var cities = systemUnderTest.getTopNCitiesInContinentOrderedByPopulation(count, continent);

        // Assert
        assertNotEquals(count, cities.size(), "Mockup supplies this count");
    }

    /**
     * getTopNCitiesInContinentOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCitiesInContinentOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 4;
        var continent = "Asia";

        // Act
        var cities = systemUnderTest.getTopNCitiesInContinentOrderedByPopulation(count, continent);

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
     * getCityByName tested that a city is returned correctly
     */
    @Test
    void getCityByNameReturnsCityTest(){
        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var cityName = "Name1";

        // Act
        var city = systemUnderTest.getCityByName(cityName);

        // Assert

        assertEquals(cityName, city.name, "Checks value specified matches that which is returned");
    }

    /**
     * getCityByName tested that null is returned when no city is found
     */
    @Test
    void getCityByNameReturnsNullTest(){
        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var cityName = "not a city name";

        // Act
        var city = systemUnderTest.getCityByName(cityName);

        // Assert

        assertNull(city, "Checks method returns null when nothing is found");
    }

    /**
     * getCityByName tested that a city is returned correctly when an uppercase name is specified
     */
    @Test
    void getCityByNameUpperCaseReturnsCityTest(){
        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var cityName = "NAME1";

        // Act
        var city = systemUnderTest.getCityByName(cityName);

        // Assert

        assertEquals("Name1", city.name, "Checks value specified matches that which is returned");
    }

    /**
     * getCityByName tested that a city is returned correctly when an uppercase name is specified
     */
    @Test
    void getCityByNameLowerCaseCaseReturnsCityTest(){
        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var cityName = "name1";

        // Act
        var city = systemUnderTest.getCityByName(cityName);

        // Assert

        assertEquals("Name1", city.name, "Checks value specified matches that which is returned");
    }
}
