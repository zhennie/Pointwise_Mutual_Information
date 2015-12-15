package me.ash.pmi.word_pair.utilities;

import me.ash.pmi.word_pair.data_structure.WordPair;

import java.util.Comparator;
/**
 * Created by ash on 10/31/15.
 */
public class WordPairComparator implements Comparator<WordPair>{

    @Override
    public int compare(WordPair wordPair1, WordPair wordPair2) {
        if (wordPair1.getPmi() < wordPair2.getPmi()) return -1;
        else if (wordPair1.getPmi() > wordPair2.getPmi()) return 1;
        else return 0;
    }
}
