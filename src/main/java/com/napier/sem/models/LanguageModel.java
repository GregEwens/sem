package com.napier.sem.models;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.models
 * User: Greg Ewens
 * Date Created: 10/04/2022 16:17
 * File Purpose: Models a language as needed by the Demographic report
 */
public class LanguageModel implements Comparable {

    /**
     * The name of the language in English
     */
    public String LanguageName;


    /**
     * The count of individuals who speak the language
     */
    public long Speakers;

    /**
     * The total population of the world
     */
    private float PopulationOfWorld;

    /**
     * The public constructor
     * @param languageName The name of the language in English
     * @param speakers The count of individuals who speak the language
     * @param worldPopulation The total population of the world
     */
    public LanguageModel(String languageName, long speakers, long worldPopulation){
        LanguageName = languageName;
        Speakers = speakers;
        PopulationOfWorld = worldPopulation;
    }

    /**
     * Use Collections.sort(languageModel) to sort a collection of LanguageModel by the number of speakers
     * @param compareLangModel The object to sort - an instance of this
     * @return An integer which is used to determine sort order
     */
    @Override
    public int compareTo(Object compareLangModel) {

        // use the speaker property to add to the comparator
        long compareSpeakers = ((LanguageModel)compareLangModel).Speakers;

        // For Descending order
        return (int) (compareSpeakers - this.Speakers);
    }

    /**
     * calculates the percentage of the world speak this language
     * @return The percentage as float
     */
    public float GetSpeakersAsPercentageOfWorld(){

        // so turns out Java just returns infinity rather than throwing an exception - very odd
        if(PopulationOfWorld == 0.00) throw new IllegalArgumentException();

        return (Speakers / PopulationOfWorld) * 100;
    }
}
