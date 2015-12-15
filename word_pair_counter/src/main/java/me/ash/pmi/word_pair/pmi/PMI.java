package me.ash.pmi.word_pair.pmi;

import me.ash.pmi.word_pair.data_structure.WordPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by ash on 10/30/15.
 */
public class PMI {

    public static void getPairCount(HashMap<String, Integer> wordCount,
                                    HashMap<HashSet<String>, Integer> pairCount,
                                    int lowerBound){

        HashSet<String> unqualified = new HashSet<String>();
        HashSet<HashSet<String>> pairNotWanted = new HashSet<HashSet<String>>();

        for (String s: wordCount.keySet()){
            if (wordCount.get(s)<lowerBound){
                unqualified.add(s);
            }
        }

        for (HashSet<String> pair: pairCount.keySet()){
            for (String s: pair){
                if (unqualified.contains(s)){
                    pairNotWanted.add(pair);
                    break;
                }
            }
        }

        for (String s: unqualified){
            wordCount.remove(s);
        }

        for (HashSet<String> pair: pairNotWanted){
            pairCount.remove(pair);
        }
    }

    public static void pushToQueue(HashMap<String, Integer> wordCount,
                                   HashMap<HashSet<String>, Integer> pairCount,
                                   PriorityQueue<WordPair> priorityQueue, double lineNum){

        for (HashSet<String> pair: pairCount.keySet()){
            ArrayList<String> al = new ArrayList<String>(pair);

            double denominator = wordCount.get(al.get(0))/lineNum *
                    wordCount.get(al.get(1))/lineNum;

            if (denominator == 0){
                System.out.println(al.get(0) + " : " + wordCount.get(al.get(0)) +
                    " ; " + al.get(1) + " : " + wordCount.get(al.get(1)));
            }

            double numerator = pairCount.get(pair)/lineNum;

            double pmi = Math.log(numerator/denominator);

            WordPair wp = new WordPair(al.get(0), al.get(1), pmi);
            priorityQueue.add(wp);


        }
    }

}
