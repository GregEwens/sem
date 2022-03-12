import com.napier.sem.entities.City;
import com.napier.sem.entities.CityJoinCountry;
import com.napier.sem.entities.Country;
import com.napier.sem.repositories.ICityRepository;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: PACKAGE_NAME
 * User: <<Your name here>>
 * Date Created: 12/03/2022 14:55
 * File Purpose: Mockup of CityReopsitory
 */
public class CityRepositoryMock implements ICityRepository {

    /**
     * Mockup of getAllCitiesOrderedByPopulation. This method returns 30 cities with values based on index
     */
    @Override
    public ArrayList<City> getAllCitiesOrderedByPopulation() {
        var cities = new ArrayList<City>();

        for (int i = 0; i < 30; i++) {
            var city = new City();

            var district = "Victoria";  // 15 victoria
            if(i > 15) district = "Queensland"; // 15 quee0snland

            // generate values based on index
            city.countryCode = Integer.toString(i);
            city.population = (int) Math.pow(2, i);
            city.district = district;
            city.id = i;
            city.name = "name" + i;

            cities.add(city);
        }

        return cities;
    }

    /**
     * Mockup of getAllCitiesJoinCountryOrderedByPopulation. This method returns 30 cities with values based on index
     */
    @Override
    public ArrayList<CityJoinCountry> getAllCitiesJoinCountryOrderedByPopulation() {
        var cities = new ArrayList<CityJoinCountry>();

        for (int i = 0; i < 30; i++) {
            var city = new CityJoinCountry();

            var region = "North Africa";  // 15 europe
            if(i > 15) region = "West Africa"; // 15 Asia

            var name = "Egypt";  // 15 europe
            if(i > 15) name = "China"; // 15 Asia

            // generate values based on index
            city.countryCode = Integer.toString(i);
            city.population = (int) Math.pow(2, i);
            city.district = "district" + i;
            city.id = i;
            city.name = "name" + i;
            city.Region = region;

            cities.add(city);
        }

        return cities;    }

}
