package com.napier.sem.unit_tests;

import com.napier.sem.entities.CapitalCity;
import com.napier.sem.entities.SpokenLanguageJoinCountry;
import com.napier.sem.repositories.ILanguageRepository;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: <<Your name here>>
 * Date Created: 09/04/2022 17:13
 * File Purpose:
 */
public class LanguageRepositoryMock implements ILanguageRepository {

    /**
     * Mockup of getAllLanguages.
     * @return This method returns 30 languages with values based on index
     */
    @Override
    public ArrayList<SpokenLanguageJoinCountry> getAllLanguages() {
        var languages = new ArrayList<SpokenLanguageJoinCountry>();

        for (int i = 0; i < 30; i++) {
            var language = new SpokenLanguageJoinCountry();

            var languageName = "English";  // 15 english
            if(i >= 15) languageName = "Spanish"; // 15 spanish

            var percentage = (1 / (i + 1)) * 100;

            // generate values based on index
            language.Language = languageName;
            language.Percentage = percentage;
            language.Population = 10000000-(int) Math.pow(2, i);

            languages.add(language);
        }

        return languages;
    }
}
