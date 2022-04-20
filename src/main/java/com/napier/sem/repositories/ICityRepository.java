package com.napier.sem.repositories;

import com.napier.sem.entities.City;
import com.napier.sem.entities.CityJoinCountry;
import java.util.List;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.repositories
 * User: Greg Ewens
 * Date Created: 12/03/2022 14:43
 * File Purpose:This interface provides methods for accessing City data
 */
public interface ICityRepository {

    /**
     * Gets all cities ordered by population ascending.
     * @return A list of all cities ordered by population ascending, the collection may be empty should no cities be
     * found.
     */
    List<City> getAllCitiesOrderedByPopulation();

    /**
     * Gets all cities ordered by population ascending.
     * @return A list of all cities ordered by population ascending, the collection may be empty should no cities be
     * found.
     */
    List<CityJoinCountry> getAllCitiesJoinCountryOrderedByPopulation();
}
