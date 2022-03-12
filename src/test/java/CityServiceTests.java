/**
 * Project Name: seMethods
 * Package: PACKAGE_NAME
 * User: Greg Ewens
 * Date Created: 12/03/2022 14:53
 * File Purpose: Unit Tests for CityService
 */

import com.napier.sem.repositories.ICityRepository;
import com.napier.sem.services.CityService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for CityService
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



}
