package com.napier.sem.models;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.models
 * User: <<Your name here>>
 * Date Created: 10/04/2022 16:17
 * File Purpose:
 */
public class LanguageModel implements Comparable {

    public String LanguageName;

    public long Speakers;

    private float PopulationOfWorld;

    public LanguageModel(String languageName, long speakers, long worldPopulation){
        LanguageName = languageName;
        Speakers = speakers;
        PopulationOfWorld = worldPopulation;
    }

    @Override
    public int compareTo(Object compareLangModel) {
        long compareSpeakers = ((LanguageModel)compareLangModel).Speakers;

        /* For Descending order */
        return (int) (compareSpeakers - this.Speakers);
    }

    public float GetSpeakersAsPercentageOfWorld(){
        return (Speakers / PopulationOfWorld) * 100;
    }
}
