/**
 * Project Name: seMethods
 * User: Greg Ewens
 * Date Created: 11/03/2022 09:07
 * File Purpose: Unit Tests for CountryRepository
 */

import com.napier.sem.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CountryRepository
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
}
