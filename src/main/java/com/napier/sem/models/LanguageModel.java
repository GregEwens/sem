package com.napier.sem.models;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.models
 * User: Greg Ewens
 * Date Created: 10/04/2022 16:17
 * File Purpose: Models a language as needed by the Demographic report
 */
public class LanguageModel implements Comparable<LanguageModel> {

    /**
     * The name of the language in English
     */
    public final String languageName;

    /**
     * The count of individuals who speak the language
     */
    public final long speakers;

    /**
     * The total population of the world
     */
    private final float populationOfWorld;

    /**
     * The public constructor
     * @param languageName The name of the language in English
     * @param speakers The count of individuals who speak the language
     * @param worldPopulation The total population of the world
     */
    public LanguageModel(String languageName, long speakers, long worldPopulation){
        this.languageName = languageName;
        this.speakers = speakers;
        populationOfWorld = worldPopulation;
    }

    /**
     * Use Collections.sort(languageModel) to sort a collection of LanguageModel by the number of speakers
     * @param compareLangModel The object to sort - an instance of this
     * @return An integer which is used to determine sort order
     */
    @Override
    public int compareTo(LanguageModel compareLangModel) {

        // use the speaker property to add to the comparator
        // For Descending order subtract from the default
        return (int) ((compareLangModel).speakers - this.speakers);
    }

    /**
     * calculates the percentage of the world speak this language
     * @return The percentage as float
     */
    public float getSpeakersAsPercentageOfWorld(){

        // so turns out Java just returns infinity rather than throwing an exception - very odd
        if(populationOfWorld == 0.00) throw new IllegalArgumentException();

        return (speakers / populationOfWorld) * 100;
    }
}
