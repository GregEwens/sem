package com.napier.sem.helpers;

import com.napier.sem.entities.SpokenLanguageJoinCountry;
import com.napier.sem.models.LanguageModel;

import java.util.ArrayList;
import java.util.Collections;

import static com.napier.sem.helpers.PopulationHelpers.sumLanguageCount;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.helpers
 * User: Greg Ewens
 * Date Created: 10/04/2022 16:51
 * File Purpose: Helper methods for Languages
 */
public class LanguageHelpers {

    /**
     * Filters a collection of SpokenLanguageJoinCountry by a specified language name
     * @param allCountries the collection to filter
     * @param languageName the language name to filter on
     * @return the filtered collection
     */
    public static ArrayList<SpokenLanguageJoinCountry> getCountriesWithLanguage(
            ArrayList<SpokenLanguageJoinCountry> allCountries,
            String languageName){

        var filteredCountries = new ArrayList<SpokenLanguageJoinCountry>();

        for (var language : allCountries) {
            if(language.Language.equalsIgnoreCase(languageName)){
                filteredCountries.add(language);
            }
        }

        return filteredCountries;
    }

    /**
     * Constructs language models from a collection of SpokenLanguageJoinCountry
     * @param allLanguages the collection of SpokenLanguageJoinCountry
     * @param worldPopulation the population of the world
     * @param languagesOfInterest The languages to include in the models
     * @return a collection of constructed language models
     */
    public static ArrayList<LanguageModel> buildLanguageModels(ArrayList<SpokenLanguageJoinCountry> allLanguages,
                                                         long worldPopulation, String[] languagesOfInterest){
        var languageModels = new ArrayList<LanguageModel>();

        for (var language: languagesOfInterest  ) {
            var spokenLanguage = getCountriesWithLanguage(allLanguages, language);

            languageModels.add(new LanguageModel(language, sumLanguageCount(spokenLanguage), worldPopulation));
        }

        Collections.sort(languageModels);

        return languageModels;
    }
}
