import com.napier.sem.entities.Country;
import com.napier.sem.repositories.ICountryRepository;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * User: <<Your name here>>
 * Date Created: 11/03/2022 11:11
 * File Purpose: Mockup of CountryRepository
 */
public class CountryRepositoryMock implements ICountryRepository {

    /**
     * Mockup of getAllCountriesOrderByPopulation. This method returns 30 countries with values based on index
     */
    @Override
    public ArrayList<Country> getAllCountriesOrderByPopulation() {
        var countries = new ArrayList<Country>();

        for (int i = 0; i < 30; i++) {
            var country = new Country();

            var continent = "Europe";  // 15 europe
            if(i > 15) continent = "Asia"; // 15 Asia

            var region = "North Africa";  // 15 europe
            if(i > 15) region = "West Africa"; // 15 Asia

            // generate values based on index
            country.Continent = continent;
            country.Code = "CD" + i;
            country.Population = (int) Math.pow(2, i);
            country.Region = region;
            country.Capital = "City" + i;
            country.Name = "Country" + i;
            country.GNP = BigDecimal.valueOf(Math.pow(2, i) + 1000);
            country.GNPOld = BigDecimal.valueOf(Math.pow(2, i) + 2000);
            country.GovernmentForm = "GovernmentForm" + i;
            country.HeadOfState = "Head of State" + i;
            country.IndepYear = (short) (1000 + (i * 3));
            country.LifeExpectancy = new BigDecimal(100 - i);
            country.LocalName = "Local Name" + i;
            country.SurfaceArea = BigDecimal.valueOf(Math.pow(2, i) - 10000);

            countries.add(country);
        }

        return countries;
    }
}
