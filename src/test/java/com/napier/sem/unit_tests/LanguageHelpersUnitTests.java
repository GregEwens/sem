package com.napier.sem.unit_tests;
import com.napier.sem.entities.SpokenLanguageJoinCountry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.napier.sem.helpers.LanguageHelpers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 10/04/2022 19:21
 * File Purpose: Unit tests for LanguageHelpers
 */
public class LanguageHelpersUnitTests {

    private final static ArrayList<SpokenLanguageJoinCountry> SpokenLanguageJoinCountryCollection =
            new ArrayList<>();

    @BeforeAll
    static void initialise(){

        var filteredLanguage = "Language1";

        var item1 = new SpokenLanguageJoinCountry();
        item1.Language = filteredLanguage;
        SpokenLanguageJoinCountryCollection.add(item1);

        var item2 = new SpokenLanguageJoinCountry();
        item2.Language = filteredLanguage;
        SpokenLanguageJoinCountryCollection.add(item2);

        var item3 = new SpokenLanguageJoinCountry();
        item3.Language = "language2";
        SpokenLanguageJoinCountryCollection.add(item3);

        var item4 = new SpokenLanguageJoinCountry();
        item4.Language = "Another language";
        SpokenLanguageJoinCountryCollection.add(item4);
    }

    /**
     * Tests getCountriesWithLanguage returns a correctly filtered collection
     */
    @Test
    void getCountriesWithLanguageReturnsFilteredCollectionTest(){
        // Arrange
        var filteredLanguage = "Language1";

        // Act
        var filteredCollection = getCountriesWithLanguage(SpokenLanguageJoinCountryCollection, filteredLanguage);

        // Assert
        assertEquals(2, filteredCollection.size());
    }

    /**
     * Tests getCountriesWithLanguage returns a correctly filtered collection
     */
    @Test
    void getCountriesWithLanguageReturnsEmptyCollectionTest(){
        // Arrange
        // Act
        var filteredCollection = getCountriesWithLanguage(SpokenLanguageJoinCountryCollection, "not a language");

        // Assert
        assertNotNull(filteredCollection);
        assertEquals(0, filteredCollection.size());
    }

    /**
     * Tests buildLanguageModels builds the correct count of models in the response
     */
    @Test
    void buildLanguageModelsBuildsCorrectCountOfModelsTest(){
        // Arrange
        var worldPopulation = 10000;
        var languagesOfInterest = new String[] {"Language1", "Language2", "Language3"};

        // Act
        var response = buildLanguageModels(SpokenLanguageJoinCountryCollection, worldPopulation, languagesOfInterest);

        // Assert
        assertEquals(3, response.size());
    }

    /**
     * Tests buildLanguageModels builds accurate models in the response
     */
    @Test
    void buildLanguageModelsBuildsAccurateModelsTest(){
        // Arrange
        var worldPopulation = 10000;
        var languagesOfInterest = new String[] {"Language2"};

        // Act
        var response = buildLanguageModels(SpokenLanguageJoinCountryCollection, worldPopulation, languagesOfInterest);

        // Assert
        assertEquals("Language2", response.get(0).LanguageName);
    }
}
