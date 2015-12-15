package me.ash.pmi.word_pair.utilities;

import me.ash.pmi.word_pair.data_structure.WordPair;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.PriorityQueue;

/**
 * Created by ash on 10/30/15.
 */
public class IO {
    /**
     * Read file by line and do word count and line matching.
     * @param path
     * @param wordCount
     * @param delimiter
     * @param pairCount
     */
    public static int readFileByLine(String path, HashMap<String, Integer> wordCount,
                                     String delimiter,
                                     HashMap<HashSet<String>, Integer> pairCount) {

        if (path == null) throw new IllegalArgumentException("wrong input");
        int lineNum = 0;
        BufferedReader br = null;
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(path));

            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine.toLowerCase();
                String[] strings = sCurrentLine.split(delimiter);

                for (int i=0; i<strings.length; i++){
                    String s = strings[i];
                    int wordNum = wordCount.getOrDefault(s, 0) + 1;
                    wordCount.put(s, wordNum);

                    for (int j=i+1; j<strings.length; j++){
                        String t = strings[j];
                        if (s.equals(t)) continue;
                        else {
                            HashSet<String> pair = new HashSet<String>();
                            pair.add(s);
                            pair.add(t);
                            int pairNum = pairCount.getOrDefault(pair, 0) + 1;
                            pairCount.put(pair, pairNum);
                        }
                    }
                }

                lineNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return lineNum;
    }

    public static void writeToFile(String path, PriorityQueue<WordPair> priorityQueue, int k,
                                   String delimiter){
        try {
            File file = new File(path);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            while(k>0 && !priorityQueue.isEmpty()){
                WordPair wp = priorityQueue.poll();
                k--;

                StringBuffer buf = new StringBuffer();

                for (String w: wp.getWordSet()){
                    System.out.println(w);
                    buf.append(w + delimiter);
                }

                buf.append(wp.getPmi());

                bw.newLine();
                bw.write(buf.toString());

            }

            bw.close();
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
