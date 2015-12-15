package me.ash.pmi.word_pair.data_structure;

import java.util.HashSet;

/**
 * Created by ash on 10/31/15.
 */
public class WordPair {

    private HashSet<String> wordSet;
    private double pmi;

    public WordPair(String wordX, String wordY, double pmi) {
        this.wordSet = new HashSet<String>();
        wordSet.add(wordX);
        wordSet.add(wordY);
        this.pmi = pmi;
    }

    public HashSet<String> getWordSet() {
        return wordSet;
    }

    public double getPmi() {
        return pmi;
    }
}
