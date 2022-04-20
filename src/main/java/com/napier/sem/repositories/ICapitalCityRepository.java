package com.napier.sem.repositories;

import com.napier.sem.entities.CapitalCity;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.repositories
 * User: Greg Ewens
 * Date Created: 12/03/2022 14:48
 * File Purpose:This interface provides methods for accessing Capital City data
 */
public interface ICapitalCityRepository {

    /**
     * Gets a collection of capital cities found in the specified continent
     * @return Returns a sorted collection of Capital Cities
     */
    ArrayList<CapitalCity> getAllCapitalCitiesOrderedByPopulation();
}
