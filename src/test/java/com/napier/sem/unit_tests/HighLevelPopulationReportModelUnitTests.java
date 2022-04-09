package com.napier.sem.unit_tests;

import com.napier.sem.models.HighLevelPopulationReportModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 09/04/2022 14:32
 * File Purpose: Unit tests for HighLevelPopulationReportModel
 */
public class HighLevelPopulationReportModelUnitTests {

    /**
     * Tests successful population calculation
     */
    @Test
    public void GetPercentCityPopulationReturnsCorrect(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 100;
        systemUnderTest.CityPopulation = 50;

        // Act
        var valueTested = systemUnderTest.GetPercentCityPopulation();

        // Assert
        assertEquals(50.00, valueTested);
    }

    /**
     * Tests successful population calculation with 0 city poulation
     */
    @Test
    public void GetPercentCityPopulationHandlesZeroCityPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 100;
        systemUnderTest.CityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.GetPercentCityPopulation();

        // Assert
        assertEquals(0, valueTested);
    }

    /**
     * Tests graceful handling of 0 population
     */
    @Test
    public void GetPercentCityPopulationHandlesZeroCountryPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 0;
        systemUnderTest.CityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.GetPercentCityPopulation();

        // Assert
        assertEquals(0, valueTested);
    }

    /**
     * Tests successful population calculation
     */
    @Test
    public void GetPercentNotCityPopulationReturnsCorrect(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 100;
        systemUnderTest.CityPopulation = 50;

        // Act
        var valueTested = systemUnderTest.GetPercentNotCityPopulation();

        // Assert
        assertEquals(50.00, valueTested);
    }

    /**
     * Tests successful population calculation with 0 city poulation
     */
    @Test
    public void GetPercentNotCityPopulationHandlesZeroCityPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 100;
        systemUnderTest.CityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.GetPercentNotCityPopulation();

        // Assert
        assertEquals(100, valueTested);
    }

    /**
     * Tests graceful handling of 0 population
     */
    @Test
    public void GetPercentNotCityPopulationHandlesZeroCountryPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 0;
        systemUnderTest.CityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.GetPercentNotCityPopulation();

        // Assert
        assertEquals(0, valueTested);
    }
}
