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
    void getPercentCityPopulationReturnsCorrect(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.name = "Test";
        systemUnderTest.population = 100;
        systemUnderTest.cityPopulation = 50;

        // Act
        var valueTested = systemUnderTest.getPercentCityPopulation();

        // Assert
        assertEquals(50.00, valueTested, "Checks the expected value of 50%");
    }

    /**
     * Tests successful population calculation with 0 city poulation
     */
    @Test
    void getPercentCityPopulationHandlesZeroCityPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.name = "Test";
        systemUnderTest.population = 100;
        systemUnderTest.cityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.getPercentCityPopulation();

        // Assert
        assertEquals(0, valueTested, "Checks method handles a zero city population");
    }

    /**
     * Tests graceful handling of 0 population
     */
    @Test
    void getPercentCityPopulationHandlesZeroCountryPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.name = "Test";
        systemUnderTest.population = 0;
        systemUnderTest.cityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.getPercentCityPopulation();

        // Assert
        assertEquals(0, valueTested, "Checks method handles a zero population without throwing an exception");
    }

    /**
     * Tests successful population calculation
     */
    @Test
    void getPercentNotCityPopulationReturnsCorrect(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.name = "Test";
        systemUnderTest.population = 100;
        systemUnderTest.cityPopulation = 50;

        // Act
        var valueTested = systemUnderTest.getPercentNotCityPopulation();

        // Assert
        assertEquals(50.00, valueTested, "Checks the expected value of 50%");
    }

    /**
     * Tests successful population calculation with 0 city poulation
     */
    @Test
    void getPercentNotCityPopulationHandlesZeroCityPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.name = "Test";
        systemUnderTest.population = 100;
        systemUnderTest.cityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.getPercentNotCityPopulation();

        // Assert
        assertEquals(100, valueTested, "Checks method handles a zero city population");
    }

    /**
     * Tests graceful handling of 0 population
     */
    @Test
    void getPercentNotCityPopulationHandlesZeroCountryPop(){
        // Arrange
        var systemUnderTest = new HighLevelPopulationReportModel();

        systemUnderTest.name = "Test";
        systemUnderTest.population = 0;
        systemUnderTest.cityPopulation = 0;

        // Act
        var valueTested = systemUnderTest.getPercentNotCityPopulation();

        // Assert
        assertEquals(0, valueTested, "Checks method handles a zero population without throwing an exception");
    }
}
