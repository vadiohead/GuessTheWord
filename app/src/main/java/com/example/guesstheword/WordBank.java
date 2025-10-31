package com.example.guesstheword;

import java.util.HashMap;

public class WordBank {

    public static HashMap<String, String> getWords(String letter) {
        HashMap<String, String> wordMap = new HashMap<>();

        if(letter.equals("A")) {
            wordMap.put("ABROAD", "adverb or adjective: beyond the boundaries of one's country : in or to a foreign country");
            wordMap.put("ABROGATE", "verb: to abolish by authoritative action");
            wordMap.put("ABRUPT", "adjective: characterized by or involving action or change without preparation or warning : sudden and unexpected");
            wordMap.put("ABSCESS", "noun: a localized collection of pus surrounded by inflamed tissue");
            wordMap.put("ABSORB", "verb: to take in and make part of an existent whole");
            wordMap.put("ABYSS", "noun: an immeasurably deep gulf or great space");
            wordMap.put("ACACIA", "noun: any of a large genus of leguminous shrubs and trees of warm regions with leaves pinnate or reduced to phyllodes and white or yellow flower clusters");
            wordMap.put("ACCELERATE", "verb: to move faster : to gain speed");
            wordMap.put("ACCENT", "noun: an effort in speech to stress one syllable over adjacent syllables");
            wordMap.put("AMPOULE", "noun: a hermetically sealed small bulbous glass vessel that is used to hold a solution for hypodermic injection");
            wordMap.put("ASCENT", "verb: to rise over something");
            wordMap.put("ANCHOR", "noun: a metal device attached to a ship or a boat by a cable and cast overboard to prevent an object from moving");
            wordMap.put("ASPIRATION", "noun: strong desire to achieve something");
            wordMap.put("ADJACENT", "adjective: neighbouring, immediately preceding or following");
            wordMap.put("ANKLE", "noun: the joint between the foot and the leg");
            wordMap.put("ARMATURE", "noun: a piece of soft iron or steel that connects the poles of a magnet or of adjacent magnets");
            wordMap.put("ACRONYM", "noun: a word (such as NATO, RADAR, or LASER) formed from the initial letter or letters of each of the successive parts or major parts of a compound term");
            wordMap.put("ASTONISHING", "noun: causing a feeling of great surprise or wonder");
            wordMap.put("APPLE", "noun: the fleshy, usually rounded red, yellow, or green edible pome fruit of a usually cultivated tree of the rose family");
            wordMap.put("AUTHENTIC", "adjective: not false or imitation");
        }
        else if(letter.equals("B")) {
            wordMap.put("BASEMENT", "noun: place where i keep yo mama");
            wordMap.put("BUOYANCY", "noun: ability to float on the water");
        }
        return wordMap;
    }

}
