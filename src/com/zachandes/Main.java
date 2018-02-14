package com.zachandes;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
     //   String[] fields;

        while ((line = indata.fileReadLine()) != null) {
            line=line.replace(",","").replace(".","")
                    .replace(";","").replace(":","")
                    .replace("'","").replace("\"","")
                    .replace("-","").replace("!","")
                    .replace("#","").replace("(","")
                    .replace(")","").replace("?","")
                    .replace("_","").replace("?","")
                    .toLowerCase().trim();
            words = line.split(" ");
            for (String s:words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                }
                else {
                    map.put(s, map.get(s) + 1);
                }
            }
        }

        int wordsUsedOnce = 0;
        String mostUsedWord = "";
        int mostUsedWordNumber = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue());

            if(entry.getValue() > mostUsedWordNumber){
                mostUsedWordNumber = entry.getValue();
                mostUsedWord = entry.getKey();
            }
            if(entry.getValue() == 1){
                wordsUsedOnce++;
            }
        }

        System.out.println("The word used the most is: " + mostUsedWord + ", and it was used " + mostUsedWordNumber + " times.");
        System.out.println("Words used once: " + wordsUsedOnce);

    }
}