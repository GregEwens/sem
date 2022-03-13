package com.napier.sem.unit_tests;

/**
 * Project Name: seMethods
 * User: Laura Main
 * Date Created: 13/03/2022 19:46
 * File Purpose: Unit Tests for Capital City Service
 */

import com.napier.sem.repositories.ICapitalCityRepository;
import com.napier.sem.repositories.ICityRepository;
import com.napier.sem.repositories.ICountryRepository;
import com.napier.sem.services.CountryService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for Capital City Service
 */
public class CapitalCityServiceTests {

    /**
     * Mockup of countryRepository
     */
    private static ICapitalCityRepository capitalCityRepositoryMock;

    /**
     * Constructs the Country Repository
     */
    @BeforeAll
    static void init()
    {
        capitalCityRepositoryMock = new CapitalCityRepositoryMock();
    }
}
