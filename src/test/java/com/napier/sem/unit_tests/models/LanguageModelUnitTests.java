package com.napier.sem.unit_tests.models;

import com.napier.sem.models.LanguageModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 10/04/2022 18:56
 * File Purpose: Unit tests for LanguageModel
 */
public class LanguageModelUnitTests {

    /**
     * Test that the override for sorting a collection sorts correctly
     */
    @Test
    void IComparableCompareToOverrideSortsCorrectly(){

        // Arrange
        var systemUnderTest = new ArrayList<LanguageModel>();

        var item1 = new LanguageModel("item1", 2000, 10000);
        var item2 = new LanguageModel("item2", 1000, 10000);
        var item3 = new LanguageModel("item3", 3000, 10000);

        systemUnderTest.add(item1);
        systemUnderTest.add(item2);
        systemUnderTest.add(item3);

        // Act
        Collections.sort(systemUnderTest);

        // Assert
        assertEquals(systemUnderTest.get(0).LanguageName, "item3");
        assertEquals(systemUnderTest.get(1).LanguageName, "item1");
        assertEquals(systemUnderTest.get(2).LanguageName, "item2");

    }

    /**
     * GetSpeakersAsPercentageOfWorld returns the correct value
     */
    @Test
    void GetSpeakersAsPercentageOfWorldReturnsCorrectValueTest(){

        // Arrange
        var systemUnderTest = new LanguageModel("item1", 1000, 10000);

        // Act
        var response = systemUnderTest.GetSpeakersAsPercentageOfWorld();

        // Assert
        assertEquals(response, 10.00);

    }

    /**
     * GetSpeakersAsPercentageOfWorld tested with 0 world population count
     */
    @Test
    void GetSpeakersAsPercentageOfWorldThrowsIllegalArgumentExceptionTest(){

        // Arrange
        var systemUnderTest = new LanguageModel("item1", 1000, 0);

        // Assert
        assertThrows(IllegalArgumentException.class, systemUnderTest::GetSpeakersAsPercentageOfWorld);
    }
}
