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
public class CityServiceTests {

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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertNotEquals(count, cities.size());
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

        assertTrue(populationFirst < populationSecond && populationSecond < populationThird && populationThird < populationFourth);
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
        assertEquals(count, cities.size());
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationCorrectCountTestAllUpper(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var region = "NORTH AFRICA";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, cities.size());
    }

    /**
     * getTopNCitiesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCitiesInRegionOrderedByPopulationCorrectCountTestAllLower(){

        // Arrange
        var systemUnderTest = new CityService(cityRepositoryMock);
        var count = 10;
        var region = "north africa";

        // Act
        var cities = systemUnderTest.getTopNCitiesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(0, cities.size());
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
        assertNotEquals(count, cities.size());
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

        assertTrue(populationFirst < populationSecond && populationSecond < populationThird && populationThird < populationFourth);
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(0, cities.size());
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
        assertNotEquals(count, cities.size());
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

        assertTrue(populationFirst < populationSecond && populationSecond < populationThird && populationThird < populationFourth);
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(0, cities.size());
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
        assertNotEquals(count, cities.size());
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

        assertTrue(populationFirst < populationSecond && populationSecond < populationThird && populationThird < populationFourth);
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(count, cities.size());
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
        assertEquals(0, cities.size());
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
        assertNotEquals(count, cities.size());
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

        assertTrue(populationFirst < populationSecond && populationSecond < populationThird && populationThird < populationFourth);
    }
}