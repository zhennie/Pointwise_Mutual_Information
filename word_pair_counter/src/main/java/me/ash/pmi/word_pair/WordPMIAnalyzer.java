package me.ash.pmi.word_pair;

import me.ash.pmi.word_pair.data_structure.WordPair;
import me.ash.pmi.word_pair.pmi.PMI;
import me.ash.pmi.word_pair.pmi.PMIAnalyzer;
import me.ash.pmi.word_pair.utilities.IO;
import me.ash.pmi.word_pair.utilities.WordPairComparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
/**
 * Created by ash on 10/31/15.
 */
public class WordPMIAnalyzer implements PMIAnalyzer<String> {


    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    private HashMap<HashSet<String>, Integer> pairCount = new HashMap<HashSet<String>, Integer>();

    private int lineNum;

    public WordPMIAnalyzer(String filePath) {

        // Read data, and construct wordCount,pairCount and etc.



    }


    //    private static HashMap<Integer, HashSet<String>> lineDict = new HashMap<Integer, HashSet<String>>();

    public static void main(String[] args) {
        String path = args[0];
        int topK = Integer.parseInt(args[1]);
        int lowerBound = Integer.parseInt(args[2]);
        String outputPath = args[3];
        String outputDelimiter = args[4];

        Comparator<WordPair> wordPairComparator = new WordPairComparator();
        PriorityQueue<WordPair> priorityQueue = new PriorityQueue<WordPair>(topK, wordPairComparator);

    }

    @Override
    public double probabilityOf(String s) {
        return this.wordCount.getOrDefault(s, 0) / (float) this.lineNum;
    }

    @Override
    public double probabilityOf(String t1, String t2) {
        return 0.0;
    }

    @Override
    public double PmiOf(String t1, String t2) {
        return 0;
    }
}
