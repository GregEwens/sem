package com.napier.sem.repositories;

import com.napier.sem.entities.Country;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Greg Ewens
 * Date Created: 11/03/2022 11:07
 * File Purpose: This class provides methods for accessing Country data
 */
public interface ICountryRepository {

    /**
     * Gets all countries.
     * @return A list of all countries, the collection may be empty should no countries be found.
     */
    ArrayList<Country> getAllCountriesOrderByPopulation();

}
