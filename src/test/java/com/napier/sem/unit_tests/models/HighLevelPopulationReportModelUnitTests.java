package com.napier.sem.unit_tests.models;

import com.napier.sem.models.HighLevelPopulationReportModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 09/04/2022 14:32
 * File Purpose: Unit tests for HighLevelPopulationReportModel
 */
class HighLevelPopulationReportModelUnitTests {

    /**
     * Tests successful population calculation
     */
    @Test
    void GetPercentCityPopulationReturnsCorrect(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 100;
        systemUnderTest.CityPopulation = 50;

        // Act
        var valueTested = systemUnderTest.GetPercentCityPopulation();

        // Assert
        assertEquals(50.00, valueTested, "Checks the expected value of 50%");
    }

    /**
     * Tests successful population calculation with 0 city poulation
     */
    @Test
    void GetPercentCityPopulationHandlesZeroCityPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 100;
        systemUnderTest.CityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.GetPercentCityPopulation();

        // Assert
        assertEquals(0, valueTested, "Checks method handles a zero city population");
    }

    /**
     * Tests graceful handling of 0 population
     */
    @Test
    void GetPercentCityPopulationHandlesZeroCountryPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 0;
        systemUnderTest.CityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.GetPercentCityPopulation();

        // Assert
        assertEquals(0, valueTested, "Checks method handles a zero population without throwing an exception");
    }

    /**
     * Tests successful population calculation
     */
    @Test
    void GetPercentNotCityPopulationReturnsCorrect(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 100;
        systemUnderTest.CityPopulation = 50;

        // Act
        var valueTested = systemUnderTest.GetPercentNotCityPopulation();

        // Assert
        assertEquals(50.00, valueTested, "Checks the expected value of 50%");
    }

    /**
     * Tests successful population calculation with 0 city poulation
     */
    @Test
    void GetPercentNotCityPopulationHandlesZeroCityPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 100;
        systemUnderTest.CityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.GetPercentNotCityPopulation();

        // Assert
        assertEquals(100, valueTested, "Checks method handles a zero city population");
    }

    /**
     * Tests graceful handling of 0 population
     */
    @Test
    void GetPercentNotCityPopulationHandlesZeroCountryPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.Name = "Test";
        systemUnderTest.Population = 0;
        systemUnderTest.CityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.GetPercentNotCityPopulation();

        // Assert
        assertEquals(0, valueTested, "Checks method handles a zero population without throwing an exception");
    }
}
