package com.napier.sem.unit_tests;

import com.napier.sem.repositories.ICountryRepository;
import com.napier.sem.services.CountryService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 11/03/2022 09:07
 * File Purpose: Unit Tests for CountryRepository
 */
public class CountryServiceTests {

    /**
     * Mockup of countryRepository
     */
    private static ICountryRepository countryRepositoryMock;

    /**
     * Constructs the Country Repository
     */
    @BeforeAll
    static void init()
    {
        countryRepositoryMock = new CountryRepositoryMock();
    }

    /**
     * getTopNCountriesOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCountriesOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 10;

        // Act
        var countries = systemUnderTest.getTopNCountriesOrderedByPopulation(count);

        // Assert
        assertEquals(count, countries.size());
    }

    /**
     * getTopNCountriesOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCountriesOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 0;

        // Act
        var countries = systemUnderTest.getTopNCountriesOrderedByPopulation(count);

        // Assert
        assertEquals(count, countries.size());
    }

    /**
     * getTopNCountriesOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCountriesOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = -1;

        // Assert
        assertThrows(IllegalArgumentException.class, () -> systemUnderTest.getTopNCountriesOrderedByPopulation(count));
    }

    /**
     * getTopNCountriesOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCountriesOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 500;

        // Act
        var countries = systemUnderTest.getTopNCountriesOrderedByPopulation(count);

        // Assert
        assertNotEquals(count, countries.size());
    }

    /**
     * getTopNCountriesOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCountriesOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 4;

        // Act
        var countries = systemUnderTest.getTopNCountriesOrderedByPopulation(count);

        // Assert
        var populationFirst = countries.get(0).Population;
        var populationSecond = countries.get(1).Population;
        var populationThird = countries.get(2).Population;
        var populationFourth = countries.get(3).Population;

        assertTrue(populationFirst < populationSecond && populationSecond < populationThird && populationThird < populationFourth);
    }

     /**
     * getTopNCountriesInRegionOrderedByPopulation tested with correct count
     */
    @Test
    void getTopNCountriesInRegionOrderedByPopulationCorrectCountTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 10;
        var region = "North Africa";

        // Act
        var countries = systemUnderTest.getTopNCountriesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, countries.size());
    }

    /**
     * getTopNCountriesInRegionOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCountriesInRegionOrderedByPopulationZeroCountTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 0;
        var region = "North Africa";

        // Act
        var countries = systemUnderTest.getTopNCountriesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(count, countries.size());
    }

    /**
     * getTopNCountriesInRegionOrderedByPopulation tested with 0 count
     */
    @Test
    void getTopNCountriesInRegionOrderedByPopulationRegionNotFoundTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 10;
        var region = "NotARegion";

        // Act
        var countries = systemUnderTest.getTopNCountriesInRegionOrderedByPopulation(count, region);

        // Assert
        assertEquals(0, countries.size());
    }

    /**
     * getTopNCountriesInRegionOrderedByPopulation tested with negative count
     */
    @Test
    void getTopNCountriesInRegionOrderedByPopulationNegativeCountThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = -1;
        var region = "North Africa";

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> systemUnderTest.getTopNCountriesInRegionOrderedByPopulation(count, region));
    }

    /**
     * getTopNCountriesInRegionOrderedByPopulation tested with a count greater than the number of existing countries
     */
    @Test
    void getTopNCountriesInRegionOrderedByPopulationMoreThanExistsCountTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 20;
        var region = "North Africa";

        // Act
        var countries = systemUnderTest.getTopNCountriesInRegionOrderedByPopulation(count, region);

        // Assert
        assertNotEquals(count, countries.size());
    }

    /**
     * getTopNCountriesInRegionOrderedByPopulation tested for correct ordering
     */
    @Test
    void getTopNCountriesInRegionOrderedByPopulationAreOrderedTest(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var count = 4;
        var region = "North Africa";

        // Act
        var countries = systemUnderTest.getTopNCountriesInRegionOrderedByPopulation(count, region);

        // Assert
        var populationFirst = countries.get(0).Population;
        var populationSecond = countries.get(1).Population;
        var populationThird = countries.get(2).Population;
        var populationFourth = countries.get(3).Population;

        assertTrue(populationFirst < populationSecond && populationSecond < populationThird && populationThird < populationFourth);
    }

    /**
     * getCountryByName returns a country correctly
     */
    @Test
    void getCountryByNameReturnsCorrectly(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var countryName = "Country0";

        // Act
        var country = systemUnderTest.getCountryByName(countryName);

        // Assert
        assertEquals(countryName, country.Name);
    }

    /**
     * getCountryByName returns a country correctly with the specified name in all lower case
     */
    @Test
    void getCountryByNameReturnsCorrectlyLowerCase(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var countryName = "country0";

        // Act
        var country = systemUnderTest.getCountryByName(countryName);

        // Assert
        assertEquals(countryName, country.Name.toLowerCase());
    }

    /**
     * getCountryByName returns a country correctly with the specified name in all upper case
     */
    @Test
    void getCountryByNameReturnsCorrectlyUpperCase(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var countryName = "COUNTRY0";

        // Act
        var country = systemUnderTest.getCountryByName(countryName);

        // Assert
        assertEquals(countryName, country.Name.toUpperCase());
    }

    /**
     * getCountryByName returns a null where the country does not exist
     */
    @Test
    void getCountryByNameReturnsNull(){

        // Arrange
        var systemUnderTest = new CountryService(countryRepositoryMock);
        var countryName = "Not a valid country name";

        // Act
        var country = systemUnderTest.getCountryByName(countryName);

        // Assert
        assertNull(country);
    }
}
