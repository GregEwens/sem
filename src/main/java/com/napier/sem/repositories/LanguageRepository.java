package com.napier.sem.repositories;

import com.napier.sem.entities.SpokenLanguageJoinCountry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.repositories
 * User: <<Your name here>>
 * Date Created: 09/04/2022 16:51
 * File Purpose:This class provides methods for accessing Language data
 */
public class LanguageRepository implements ILanguageRepository  {

    /**
     * The MySQL database connection
     */
    private final Connection con;

    /**
     * Creates a new instance of the LanguageRepository.
     * @param connection The database we will query
     */
    public LanguageRepository (Connection connection){
        con = connection;
    }

    /**
     * @inheritDoc
     */
    @Override
    public ArrayList<SpokenLanguageJoinCountry> getAllLanguages() {
        // Create string for SQL statement
        String strSelect =
                "SELECT c.Name, c.Population, cl.Language, cl.Percentage "
                        + "FROM countrylanguage cl JOIN country c ON c.code = cl.CountryCode "
                        + "ORDER BY Population DESC";

        return getSpokenLanguageCollection(strSelect);
    }

    /**
     * Queries the city table using the supplied SQL statement. This input is not validated and must be sanitised
     * before calling this method.
     * @param SQLStatement An SQL statement which must return one or more complete City entities
     * @return A collection of Capital Cities
     */
    private ArrayList<SpokenLanguageJoinCountry> getSpokenLanguageCollection(String SQLStatement){
        try
        {
            // Create an SQL statement
            Statement statement = con.createStatement();

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery(SQLStatement);

            // create our collection
            ArrayList<SpokenLanguageJoinCountry> languages = new ArrayList<>();

            // read the results and map to our entity
            while (resultSet.next())
            {
                SpokenLanguageJoinCountry language = new SpokenLanguageJoinCountry();

                language.Language = resultSet.getString("Language");
                language.Population = resultSet.getInt("Population");
                language.Percentage = resultSet.getFloat("Percentage");

                languages.add(language);
            }

            // return our collection
            return languages;
        }
        catch (Exception e)
        {
            // log exceptions to the screen
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
}
