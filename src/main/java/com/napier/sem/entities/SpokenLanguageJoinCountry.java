package com.napier.sem.entities;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.entities
 * User: Greg Ewens
 * Date Created: 09/04/2022 16:53
 * File Purpose: DTO entity extends City and used when mapping from SpokenLanguage joined to Country
 */
@SuppressWarnings("unused")// This entity maps to the database table. Properties not used should be reviewed
// periodically and once the app is feature complete
public class SpokenLanguageJoinCountry extends Country {

    /**
     * The name of the language
     */
    public String Language;

    /**
     * If the language is officially recognised by the country
     */
    public boolean IsOfficial;

    /**
     * The percentage of the country's population that speaks the language
     */
    public float Percentage;
}
