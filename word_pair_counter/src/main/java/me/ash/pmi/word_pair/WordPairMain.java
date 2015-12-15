package me.ash.pmi.word_pair;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ash on 10/31/15.
 */
public class WordPairMain {
    public static void main(String[] args) {
        HashSet<String> s1 = new HashSet<String>();
        HashSet<String> s2 = new HashSet<String>();

        s1.add("haha");
        s1.add("fuck");

        s2.add("fuck");
        s2.add("haha");

        HashMap<HashSet<String>, Integer> map = new HashMap<HashSet<String>, Integer>();

        int c = map.getOrDefault(s1, 0);
        map.put(s1, ++c);

        c = map.getOrDefault(s2, 0);
        map.put(s2, ++c);

        System.out.println(map.keySet());
    }
}
