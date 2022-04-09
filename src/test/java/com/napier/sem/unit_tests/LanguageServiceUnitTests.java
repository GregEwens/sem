package com.napier.sem.unit_tests;

import com.napier.sem.repositories.ICapitalCityRepository;
import com.napier.sem.repositories.ILanguageRepository;
import org.junit.jupiter.api.BeforeAll;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 09/04/2022 17:12
 * File Purpose:
 */
public class LanguageServiceUnitTests {

    /**
     * Mockup of countryRepository
     */
    private static ILanguageRepository languageRepositoryMock;

    /**
     * Constructs the Country Repository
     */
    @BeforeAll
    static void init()
    {
        languageRepositoryMock = new LanguageRepositoryMock();
    }



}
