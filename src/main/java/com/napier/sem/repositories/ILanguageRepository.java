package com.napier.sem.repositories;

import com.napier.sem.entities.SpokenLanguageJoinCountry;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.repositories
 * User: <<Your name here>>
 * Date Created: 09/04/2022 16:52
 * File Purpose:
 */
public interface ILanguageRepository {

    /**
     * Gets all countries.
     * @return A list of all countries, the collection may be empty should no countries be found.
     */
    ArrayList<SpokenLanguageJoinCountry> getAllLanguages();
}
