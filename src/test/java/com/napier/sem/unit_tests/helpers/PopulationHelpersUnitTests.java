package com.napier.sem.unit_tests.helpers;

import com.napier.sem.entities.City;
import com.napier.sem.entities.Country;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.napier.sem.helpers.PopulationHelpers.sumCityPopulation;
import static com.napier.sem.helpers.PopulationHelpers.sumCountryPopulation;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 09/04/2022 14:45
 * File Purpose: Unit tests for PopulationHelpers
 */
public class PopulationHelpersUnitTests {

    /**
     * Tests a correct count for sumCityPopulation
     */
    @Test
    public void sumCityPopulationCorrectCountTest() {
        // Arrange
        var cities = new ArrayList<City>();

        var city1 = new City();
        city1.population = 100;
        cities.add(city1);

        var city2 = new City();
        city2.population = 100;
        cities.add(city2);

        var city3 = new City();
        city3.population = 100;
        cities.add(city3);

        // Act
        var populationCount = sumCityPopulation(cities);

        // Assert
        assertEquals(300, populationCount);
    }

    /**
     * Tests sumCityPopulation handles an empty list
     */
    @Test
    public void sumCityPopulationHandlesEmptyListTest() {
        // Arrange
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") // no need to use cities as we're only testing the
        // output so we can suppress this warning
        var cities = new ArrayList<City>();

        // Act
        var populationCount = sumCityPopulation(cities);

        // Assert
        assertEquals(0, populationCount);
    }

    /**
     * Tests a correct count for sumCountryPopulation
     */
    @Test
    public void sumCountryPopulationCorrectCountTest() {
        // Arrange
        var countries = new ArrayList<Country>();

        var country1 = new Country();
        country1.Population = 100;
        countries.add(country1);

        var country2 = new Country();
        country2.Population = 100;
        countries.add(country2);

        var country3 = new Country();
        country3.Population = 100;
        countries.add(country3);

        // Act
        var populationCount = sumCountryPopulation(countries);

        // Assert
        assertEquals(300, populationCount);
    }

    /**
     * Tests sumCountryPopulation handles an empty list
     */
    @Test
    public void sumCountryPopulationHandlesEmptyListTest() {
        // Arrange
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") // no need to use cities as we're only testing the
        // output so we can suppress this warning
        var countries = new ArrayList<Country>();

        // Act
        var populationCount = sumCountryPopulation(countries);

        // Assert
        assertEquals(0, populationCount);
    }
}