package com.napier.sem.helpers;

import com.napier.sem.entities.SpokenLanguageJoinCountry;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.helpers
 * User: <<Your name here>>
 * Date Created: 10/04/2022 16:51
 * File Purpose:
 */
public class LanguageHelpers {

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
}
