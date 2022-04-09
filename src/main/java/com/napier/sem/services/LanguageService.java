package com.napier.sem.services;

import com.napier.sem.entities.SpokenLanguageJoinCountry;
import com.napier.sem.repositories.ILanguageRepository;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.services
 * User: Greg Ewens
 * Date Created: 09/04/2022 17:09
 * File Purpose: Processes business logic for demographic reports
 */
public class LanguageService {

    /**
     * The Language Repository
     */
    private final ILanguageRepository _languageRepository;

    /**
     * The public constructor
     * @param languageRepository An instance of the ILanguageRepository
     */
    public LanguageService(ILanguageRepository languageRepository){
        _languageRepository = languageRepository;
    }

    /**
     * Gets a collection of all capital cities
     * @return Returns a sorted collection of Capital Cities
     */
    public ArrayList<SpokenLanguageJoinCountry> getAllLanguages(){
        var allLanguages =  _languageRepository.getAllLanguages();



        return allLanguages;
    }

    private ArrayList<SpokenLanguageJoinCountry> getCountriesWithLanguage(
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
