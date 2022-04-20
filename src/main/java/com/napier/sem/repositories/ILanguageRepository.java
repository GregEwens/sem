package com.napier.sem.repositories;

import com.napier.sem.entities.SpokenLanguageJoinCountry;

import java.util.List;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.repositories
 * User: Greg Ewens
 * Date Created: 09/04/2022 16:52
 * File Purpose: This class provides methods for accessing Language data
 */
public interface ILanguageRepository {

    /**
     * Gets all countries.
     * @return A list of all countries, the collection may be empty should no countries be found.
     */
    List<SpokenLanguageJoinCountry> getAllLanguages();
}
