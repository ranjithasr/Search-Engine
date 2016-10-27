package com.ranjitha.se;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Indexer {

    // Map to store an index of words and list of documents the word is present in.
    HashMap<String, List<String>> index = new HashMap<String, List<String>>();

    /* Returns a map of the words and the corresponding list of documents the word is present in. */
    public HashMap<String, List<String>> indexDocs(Document[] docs){
        for(int i = 0; i< docs.length; i++){
            Document document =  docs[i];
            String body = document.getBody();
            int id = document.getDocId();
            String fileName= document.getFileName();
            String[] words = body.split(" ");
            for(int j = 0; j< words.length; j++){
                if(index.containsKey(words[j])){
                    List<String> fileNames = index.get(words[j]);
                    fileNames.add(fileName);
                    index.put(words[j],fileNames);

                }else{
                    List<String> filesNames = new ArrayList<String>();
                    filesNames.add(fileName);
                    index.put(words[j],filesNames);
                }
            }

        }
        return index;
    }
}
